package image15;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PuzzlePanel extends JPanel implements MouseListener {

    private static final int SIZE = 4;
    private static final int TILE_SIZE = 120;

    private PuzzlePiece[][] board;
    private int emptyRow, emptyCol;
    private int moveCount;
    private boolean showImages;
    private boolean gameWon;

    private BufferedImage[] tileImages;

    private JPanel gridCanvas;
    private JLabel moveLabel;
    private JButton newGameButton;
    private JButton toggleButton;
    private JLabel winLabel;

    public PuzzlePanel() {
        setLayout(new BorderLayout());
        board = new PuzzlePiece[SIZE][SIZE];
        showImages = false;
        gameWon = false;

        loadImage();
        initControls();
        initGridCanvas();
        newGame();
    }


    private void loadImage() {
        tileImages = new BufferedImage[SIZE * SIZE];
        try {
            BufferedImage full = ImageIO.read(new File("src/image15/image.png"));

            int gridPx = SIZE * TILE_SIZE;
            BufferedImage scaled = new BufferedImage(gridPx, gridPx, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = scaled.createGraphics();
            g.drawImage(full, 0, 0, gridPx, gridPx, null);

            for (int i = 0; i < SIZE * SIZE; i++) {
                int r = i / SIZE;
                int c = i % SIZE;
                tileImages[i] = scaled.getSubimage(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private void initControls() {
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 8));

        moveLabel = new JLabel("Moves: 0");
        moveLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        newGameButton = new JButton("New Game");
        newGameButton.setEnabled(false);
        newGameButton.addActionListener(e -> newGame());

        toggleButton = new JButton("Images");
        toggleButton.addActionListener(e -> toggleMode());

        top.add(moveLabel);
        top.add(newGameButton);
        top.add(toggleButton);
        add(top, BorderLayout.NORTH);
    }

    private void initGridCanvas() {
        int gridPx = SIZE * TILE_SIZE + (SIZE - 1);

        gridCanvas = new GridCanvas();
        gridCanvas.setPreferredSize(new Dimension(gridPx, gridPx));
        gridCanvas.setBackground(Color.DARK_GRAY);
        gridCanvas.addMouseListener(this);

        add(gridCanvas, BorderLayout.CENTER);
    }

    private class GridCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawGrid((Graphics2D) g);
        }
    }
    // ── Drawing ────────────────────────────────────────────────────────────────

    private void drawGrid(Graphics2D g) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int x = c * (TILE_SIZE);
                int y = r * (TILE_SIZE);
                PuzzlePiece piece = board[r][c];

                if (piece == null) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                } else if (showImages && tileImages != null) {
                    g.drawImage(piece.getImage(), x, y, TILE_SIZE, TILE_SIZE, null);
                } else {
                    g.setColor(new Color(70, 130, 180));
                    g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("SansSerif", Font.BOLD, 36));
                    FontMetrics fm = g.getFontMetrics();
                    String txt = String.valueOf(piece.getValue());
                    g.drawString(txt,
                            x + (TILE_SIZE - fm.stringWidth(txt)) / 2,
                            y + (TILE_SIZE + fm.getAscent() - fm.getDescent()) / 2);
                }
            }
        }
    }

    // ── Game logic ─────────────────────────────────────────────────────────────

    private void newGame() {
        gameWon = false;
        moveCount = 0;
        moveLabel.setText("Moves: 0");
        winLabel.setText(" ");
        newGameButton.setEnabled(false);

        // Start from the solved state
        for (int i = 0; i < SIZE * SIZE - 1; i++) {
            int r = i / SIZE, c = i % SIZE;
            board[r][c] = new PuzzlePiece(i + 1, tileImages != null ? tileImages[i] : null);
        }
        board[SIZE - 1][SIZE - 1] = null;
        emptyRow = SIZE - 1;
        emptyCol = SIZE - 1;

        // Shuffle by making 200 random valid moves — always solvable
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Random rand = new Random();
        for (int i = 0; i < 200; i++) {
            List<int[]> moves = new ArrayList<>();
            for (int[] d : dirs) {
                int nr = emptyRow + d[0], nc = emptyCol + d[1];
                if (nr >= 0 && nr < SIZE && nc >= 0 && nc < SIZE)
                    moves.add(new int[]{nr, nc});
            }
            int[] move = moves.get(rand.nextInt(moves.size()));
            board[emptyRow][emptyCol] = board[move[0]][move[1]];
            board[move[0]][move[1]] = null;
            emptyRow = move[0];
            emptyCol = move[1];
        }

        gridCanvas.repaint();
    }

    private void toggleMode() {
        showImages = !showImages;
        toggleButton.setText(showImages ? "Numbers" : "Images");
        gridCanvas.repaint();
    }

    private void checkWin() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int expected = r * SIZE + c + 1;
                if (expected == SIZE * SIZE) {
                    if (board[r][c] != null) return;
                } else {
                    if (board[r][c] == null || board[r][c].getValue() != expected) return;
                }
            }
        }
        gameWon = true;
        newGameButton.setEnabled(true);
    }

    // ── MouseListener ──────────────────────────────────────────────────────────

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameWon) return;

        int col = e.getX() / (TILE_SIZE);
        int row = e.getY() / (TILE_SIZE);

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) return;
        if (board[row][col] == null) return;

        boolean adjacent = Math.abs(row - emptyRow) + Math.abs(col - emptyCol) == 1;
        if (!adjacent) return;

        board[emptyRow][emptyCol] = board[row][col];
        board[row][col] = null;
        emptyRow = row;
        emptyCol = col;
        moveCount++;
        moveLabel.setText("Moves: " + moveCount);

        gridCanvas.repaint();
        checkWin();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}