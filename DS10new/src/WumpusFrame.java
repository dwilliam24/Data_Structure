import javax.swing.*;
import java.awt.*;

public class WumpusFrame extends JFrame {
    public WumpusFrame() {
        super("Wumpus");
        setSize(1000, 1000);
        WumpusPanel a = new WumpusPanel();
        add(a);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
