import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;
    private WumpusPlayer player;
    private WumpusMap map;

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
        setBounds(0, 0, 900, 900);
        buffer = new BufferedImage(600,700, BufferedImage.TYPE_4BYTE_ABGR);

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

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            System.out.println("a");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
    }

    public void reset() {
        status = 0;
        map = new WumpusMap();
        player = new WumpusPlayer(0, true, false);
    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        for (int x = 0; x < map.NUM_ROWS; x++) {
            for (int y = 0; y < map.NUM_COLUMNS; y++) {
                bg.drawImage(floor,(y*50),(x*50),null);
            }
        }
        for (int x = 0; x < map.NUM_ROWS; x++) {
            for (int y = 0; y < map.NUM_COLUMNS; y++) {
                String a = map.getSquare(y,x).toString();
                if (a.equals("@")){
                    bg.drawImage(gold,(y*50),(x*50),null);
                    bg.drawImage(wumpus,(y*50),(x*50),null);
                }
                else if (a.equals("!")){
                    bg.drawImage(gold,(y*50),x*50,null);
                    bg.drawImage(deadWumpus,(y*50),(x*50),null);
                }
                else if (a.equals("G")){
                    bg.drawImage(gold,(y*50),x*50,null);
                }
                else if (a.equals("P")){
                    bg.drawImage(pit,(y*50),x*50,null);
                }
                else if (a.equals("W")){
                    bg.drawImage(wumpus,(y*50),x*50,null);
                }else if (a.equals("D")){
                    bg.drawImage(deadWumpus,(y*50),x*50,null);
                }
                else if (a.equals("L")){
                    bg.drawImage(ladder,(y*50),x*50,null);
                }
                else if (map.getSquare(y,x).getStench()){
                    bg.drawImage(stench,(y*50),x*50,null);
                }
                else if (map.getSquare(y,x).getBreeze()){
                    bg.drawImage(breeze,(y*50),x*50,null);
                }

            }
        }

        g.drawImage(buffer,0,0,null);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
