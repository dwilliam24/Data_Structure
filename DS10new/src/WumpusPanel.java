import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING =0;
    public static final int DEAD =1;
    public static final int WON =2;
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
    public WumpusPanel(){
        try {
            floor = ImageIO.read(new File("src/WumpusImages/Floor.gif"));
            arrow = ImageIO.read(new File("src/WumpusImages/arrow.gif"));
            fog = ImageIO.read(new File("src/WumpusImages/black.gif"));
            gold = ImageIO.read(new File("src/WumpusImages/gold.gif"));
            ladder = ImageIO.read(new File("src/WumpusImages/ladder.gif"));
            pit = ImageIO.read(new File("src/WumpusImages/pit.gif"));
            breeze = ImageIO.read(new File("src/WumpusImages/breeze.gif"));
            wumpus = ImageIO.read(new File("src/WumpusImages/wumpus.gif"));
            deadWumpus = ImageIO.read(new File("src/WumpusImages/deadwumpus.gif"));
            stench = ImageIO.read(new File("src/WumpusImages/stench.gif"));
            playerUp = ImageIO.read(new File("src/WumpusImages/playerUp.png"));
            playerDown = ImageIO.read(new File("src/WumpusImages/playerDown.png"));
            playerLeft = ImageIO.read(new File("src/WumpusImages/playerLeft.png"));
            playerRight = ImageIO.read(new File("src/WumpusImages/playerRight.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
