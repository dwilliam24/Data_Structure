import javax.swing.*;

public class WumpusFrame extends JFrame {
    public WumpusFrame() {
        super("Wumpus");
        add(new WumpusPanel());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
