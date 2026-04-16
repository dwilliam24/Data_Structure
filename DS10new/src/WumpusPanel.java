import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;
    private WumpusPlayer player;
    private WumpusMap map;
    private boolean cheat;
    private String message;

    private BufferedImage floor;
    private BufferedImage arrow;
    private BufferedImage fog;
    private BufferedImage gold;
    private BufferedImage ladder;
    private BufferedImage pit;
    private BufferedImage breeze;
    private BufferedImage wumpus;
    private BufferedImage deadWumpus;
    private BufferedImage stench;
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage buffer;

    public WumpusPanel() {
        setPreferredSize(new Dimension(500, 620));
        buffer = new BufferedImage(500, 620, BufferedImage.TYPE_4BYTE_ABGR);
        addKeyListener(this);
        try {
            floor = ImageIO.read(new File("src/WumpusImages/Floor.gif"));
            arrow = ImageIO.read(new File("src/WumpusImages/arrow.gif"));
            fog = ImageIO.read(new File("src/WumpusImages/black.gif"));
            gold = ImageIO.read(new File("src/WumpusImages/gold.gif"));
            ladder = ImageIO.read(new File("src/WumpusImages/ladder.gif"));
            pit = ImageIO.read(new File("src/WumpusImages/pit.gif"));
            breeze = ImageIO.read(new File("src/WumpusImages/breeze.gif"));
            wumpus = ImageIO.read(new File("src/WumpusImages/wumpus.gif"));
            deadWumpus = ImageIO.read(new File("src/WumpusImages/deadWumpus.gif"));
            stench = ImageIO.read(new File("src/WumpusImages/stench.gif"));
            playerUp = ImageIO.read(new File("src/WumpusImages/playerUp.png"));
            playerDown = ImageIO.read(new File("src/WumpusImages/playerDown.png"));
            playerLeft = ImageIO.read(new File("src/WumpusImages/playerLeft.png"));
            playerRight = ImageIO.read(new File("src/WumpusImages/playerRight.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        reset();
    }

    public void reset() {
        status = PLAYING;
        cheat = false;
        map = new WumpusMap();
        player = new WumpusPlayer();
        player.setColPosition(map.getLadderCol());
        player.setRowPosition(map.getLadderRow());
        map.getSquare(map.getLadderCol(), map.getLadderRow()).setVisited(true);
        message = "You smack ur huge cranium into a ladder";
    }

    private void checkCurrentSquare() {
        int col = player.getColPosition();
        int row = player.getRowPosition();
        WumpusSquare sq = map.getSquare(col, row);
        if (sq == null) return;

        if (sq.getPit()) {
            message = "you slipped and fell... oopsie >_<";
            status = DEAD;
            return;
        }
        if (sq.getWumpus()) {
            message = "you got munched by a wumpy.. :3";
            status = DEAD;
            return;
        }

        StringBuilder msg = new StringBuilder();
        if (sq.getBreeze()) msg.append("you feel the wind running through your toes");
        if (sq.getStench() || sq.getDeadWumpus()) msg.append("You smell a stench.  ");
        if (sq.getGold() && !player.getGold()) msg.append("You see a glimmer!  ");
        if (sq.getLadder()) msg.append("You smack ur huge cranium into a ladder");
        message = msg.toString().trim();
    }

    private void shoot(int dirCol, int dirRow) {
        if (!player.getArrow()) return;
        player.setArrow(false);

        int[] wLoc = map.wumpusLoc();
        boolean hit = false;
        if (wLoc != null) {
            int wCol = wLoc[0], wRow = wLoc[1];
            int pCol = player.getColPosition(), pRow = player.getRowPosition();
            if (dirCol == 0 && wCol == pCol && (dirRow < 0 ? wRow < pRow : wRow > pRow)) hit = true;
            if (dirRow == 0 && wRow == pRow && (dirCol < 0 ? wCol < pCol : wCol > pCol)) hit = true;
        }

        if (hit) {
            map.getSquare(wLoc[0], wLoc[1]).setWumpus(false);
            map.getSquare(wLoc[0], wLoc[1]).setDeadWumpus(true);
            message = "You hear a scream!";
        } else {
            message = "Your arrow flies into the darkness...";
        }
    }

    public void keyTyped(KeyEvent e) {
        char key = Character.toLowerCase(e.getKeyChar());

        if (key == 'n') {
            if (status != PLAYING) {
                reset();
                repaint();
            }
            return;
        }

        if (key == '*') {
            cheat = !cheat;
            repaint();
            return;
        }

        if (status != PLAYING) return;

        int col = player.getColPosition();
        int row = player.getRowPosition();

        if (key == 'w') {
            if (player.getDirection() == WumpusPlayer.NORTH) {
                if (row > 0) {
                    player.setRowPosition(row - 1);
                    map.getSquare(col, row - 1).setVisited(true);
                    checkCurrentSquare();
                }
            } else {
                player.setDirection(WumpusPlayer.NORTH);
            }
        } else if (key == 's') {
            if (player.getDirection() == WumpusPlayer.SOUTH) {
                if (row < WumpusMap.NUM_ROWS - 1) {
                    player.setRowPosition(row + 1);
                    map.getSquare(col, row + 1).setVisited(true);
                    checkCurrentSquare();
                }
            } else {
                player.setDirection(WumpusPlayer.SOUTH);
            }
        } else if (key == 'a') {
            if (player.getDirection() == WumpusPlayer.WEST) {
                if (col > 0) {
                    player.setColPosition(col - 1);
                    map.getSquare(col - 1, row).setVisited(true);
                    checkCurrentSquare();
                }
            } else {
                player.setDirection(WumpusPlayer.WEST);
            }
        } else if (key == 'd') {
            if (player.getDirection() == WumpusPlayer.EAST) {
                if (col < WumpusMap.NUM_COLUMNS - 1) {
                    player.setColPosition(col + 1);
                    map.getSquare(col + 1, row).setVisited(true);
                    checkCurrentSquare();
                }
            } else {
                player.setDirection(WumpusPlayer.EAST);
            }
        } else if (key == 'i') {
            if (player.getDirection() == WumpusPlayer.NORTH) {
                shoot(0, -1);
            }
        } else if (key == 'k') {
            if (player.getDirection() == WumpusPlayer.SOUTH) {
                shoot(0, +1);
            }
        } else if (key == 'j') {
            if (player.getDirection() == WumpusPlayer.WEST) {
                shoot(-1, 0);
            }
        } else if (key == 'l') {
            if (player.getDirection() == WumpusPlayer.EAST) {
                shoot(+1, 0);
            }
        } else if (key == 'p') {
            WumpusSquare sq = map.getSquare(col, row);
            if (sq.getGold() && !player.getGold()) {
                player.setGold(true);
                sq.setGold(false);
                message = "You pick up the gold!";
            }
        } else if (key == 'c') {
            WumpusSquare sq = map.getSquare(col, row);
            if (sq.getLadder() && player.getGold()) {
                status = WON;
                message = "You escaped the cave with the gold!";
            }
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();

        for (int r = 0; r < WumpusMap.NUM_ROWS; r++) {
            for (int c = 0; c < WumpusMap.NUM_COLUMNS; c++) {
                bg.drawImage(floor, c * 50, r * 50, null);
            }
        }

        for (int r = 0; r < WumpusMap.NUM_ROWS; r++) {
            for (int c = 0; c < WumpusMap.NUM_COLUMNS; c++) {
                WumpusSquare sq = map.getSquare(c, r);
                if (!cheat && !sq.getVisited()) {
                    bg.drawImage(fog, c * 50, r * 50, null);
                } else if (sq.toString().equals("@")) {
                    bg.drawImage(gold, c * 50, r * 50, null);
                    bg.drawImage(wumpus, c * 50, r * 50, null);
                } else if (sq.toString().equals("!")) {
                    bg.drawImage(gold, c * 50, r * 50, null);
                    bg.drawImage(deadWumpus, c * 50, r * 50, null);
                } else if (sq.toString().equals("G")) {
                    bg.drawImage(gold, c * 50, r * 50, null);
                } else if (sq.toString().equals("P")) {
                    bg.drawImage(pit, c * 50, r * 50, null);
                } else if (sq.toString().equals("W")) {
                    bg.drawImage(wumpus, c * 50, r * 50, null);
                } else if (sq.toString().equals("D")) {
                    bg.drawImage(deadWumpus, c * 50, r * 50, null);
                } else if (sq.toString().equals("L")) {
                    bg.drawImage(ladder, c * 50, r * 50, null);
                } else if (sq.getStench()) {
                    bg.drawImage(stench, c * 50, r * 50, null);
                } else if (sq.getBreeze()) {
                    bg.drawImage(breeze, c * 50, r * 50, null);
                }
            }
        }

        BufferedImage pImg = playerUp;
        if (player.getDirection() == WumpusPlayer.SOUTH) pImg = playerDown;
        else if (player.getDirection() == WumpusPlayer.WEST) pImg = playerLeft;
        else if (player.getDirection() == WumpusPlayer.EAST) pImg = playerRight;
        bg.drawImage(pImg, player.getColPosition() * 50, player.getRowPosition() * 50, null);

        bg.setColor(new Color(30, 30, 30));
        bg.fillRect(0, 500, 500, 120);

        bg.setFont(new Font("Arial", Font.BOLD, 13));
        bg.setColor(Color.LIGHT_GRAY);
        bg.drawString("Inventory:", 8, 520);
        int invX = 90;
        if (player.getArrow()) {
            bg.drawImage(arrow, invX, 505, 30, 30, null);
            invX += 38;
            bg.drawString("Arrow", invX, 525);
            invX += 48;
        }
        if (player.getGold()) {
            bg.drawImage(gold, invX, 505, 30, 30, null);
            invX += 38;
            bg.drawString("Gold", invX, 525);
        }

        bg.setColor(Color.WHITE);
        bg.setFont(new Font("Arial", Font.PLAIN, 13));
        bg.drawString(message, 8, 550);

        if (status == DEAD) {
            bg.drawString("GAME OVER  -  Press 'N' for a new game", 8, 580);
        } else if (status == WON) {
            bg.drawString("YOU WIN!  -  Press 'N' for a new game", 8, 580);
        }

        g.drawImage(buffer, 0, 0, null);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}