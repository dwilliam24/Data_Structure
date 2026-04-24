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
    private static final int H = 40;
    private static final int winH = 30;
    private static final int width = SIZE * TILE_SIZE;
    private static final int height = H + (SIZE * TILE_SIZE) + winH;

    private PuzzlePiece[][] board;
    private int emptyRow, emptyCol;
    private int moveCount;
    private boolean showImages;
    private boolean gameWon;

    private BufferedImage[] tileImages;
    private int imageIndex = 1;

    private JLabel moveLabel;
    private JButton newGameButton;
    private JButton toggleButton;
    private JButton nextImageButton;
    private JLabel winLabel;

    public PuzzlePanel() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        board = new PuzzlePiece[SIZE][SIZE];
        showImages = false;
        gameWon = false;

        loadImage();
        buttons();
        addMouseListener(this);
        newGame();
    }

    private void loadImage() {
        tileImages = new BufferedImage[SIZE * SIZE];
        try {
            BufferedImage full = ImageIO.read(new File("src/image15/image" + imageIndex + ".png"));
            BufferedImage scaled = new BufferedImage(SIZE * TILE_SIZE, SIZE * TILE_SIZE, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = scaled.createGraphics();
            g.drawImage(full, 0, 0, SIZE * TILE_SIZE, SIZE * TILE_SIZE, null);

            for (int i = 0; i < SIZE * SIZE; i++) {
                int r = i / SIZE, c = i % SIZE;
                tileImages[i] = scaled.getSubimage(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        } catch (IOException e) {
            tileImages = null;
        }
    }

    private void buttons() {
        moveLabel = new JLabel("Moves: 0");
        moveLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        moveLabel.setBounds(5, 5, 100, 30);

        newGameButton = new JButton("New Game");
        newGameButton.setEnabled(false);
        newGameButton.setBounds(110, 5, 100, 30);
        newGameButton.addActionListener(e -> newGame());

        toggleButton = new JButton("Images");
        toggleButton.setBounds(215, 5, 90, 30);
        toggleButton.addActionListener(e -> toggleMode());

        nextImageButton = new JButton("Next Image");
        nextImageButton.setBounds(310, 5, 110, 30);
        nextImageButton.addActionListener(e -> nextImage());

        winLabel = new JLabel(" ");
        winLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        winLabel.setForeground(new Color(0, 140, 0));
        winLabel.setBounds(0, H + (SIZE * TILE_SIZE), width, winH);

        add(moveLabel);
        add(newGameButton);
        add(toggleButton);
        add(nextImageButton);
        add(winLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid((Graphics2D) g);
    }

    private void drawGrid(Graphics2D g) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int x = c * TILE_SIZE;
                int y = H + r * TILE_SIZE;
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
                    g.drawString(txt, x + (TILE_SIZE - fm.stringWidth(txt)) / 2, y + (TILE_SIZE + fm.getAscent() - fm.getDescent()) / 2);
                }
            }
        }
    }

    private void newGame() {
        gameWon = false;
        moveCount = 0;
        moveLabel.setText("Moves: 0");
        winLabel.setText(" ");
        newGameButton.setEnabled(false);

        for (int i = 0; i < SIZE * SIZE - 1; i++) {
            int r = i / SIZE, c = i % SIZE;
            board[r][c] = new PuzzlePiece(i + 1, tileImages != null ? tileImages[i] : null);
        }
        board[SIZE - 1][SIZE - 1] = null;
        emptyRow = SIZE - 1;
        emptyCol = SIZE - 1;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Random rand = new Random();
        for (int i = 0; i < 200; i++) {
            List<int[]> moves = new ArrayList<>();
            for (int[] d : dirs) {
                int r = emptyRow + d[0];
                int c = emptyCol + d[1];
                if (r >= 0 && r < SIZE && c >= 0 && c < SIZE)
                    moves.add(new int[]{r, c});
            }
            int[] move = moves.get(rand.nextInt(moves.size()));
            board[emptyRow][emptyCol] = board[move[0]][move[1]];
            board[move[0]][move[1]] = null;
            emptyRow = move[0];
            emptyCol = move[1];
        }
        repaint();
    }

    private void toggleMode() {
        showImages = !showImages;
        if (showImages) toggleButton.setText("Numbers");
        else toggleButton.setText("Images");
        repaint();
    }

    private void nextImage() {
        imageIndex++;
        loadImage();

        if (tileImages == null) {
            imageIndex = 1;
            loadImage();
        }

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] != null) {
                    int val = board[r][c].getValue();
                    board[r][c] = new PuzzlePiece(val, tileImages[val - 1]);
                }
            }
        }

        repaint();
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
        winLabel.setText("Puzzle solved in " + moveCount + " moves! Press New Game to play again.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameWon) return;

        int col = e.getX() / TILE_SIZE;
        int row = (e.getY() - H) / TILE_SIZE;

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

        repaint();
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