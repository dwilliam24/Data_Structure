package image15;

import javax.swing.*;

public class PuzzleFrame extends JFrame {
    public PuzzleFrame() {
        super("15 Puzzle");
        add(new PuzzlePanel());
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
