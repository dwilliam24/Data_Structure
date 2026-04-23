package image15;

import javax.swing.JFrame;

public class PuzzleFrame extends JFrame {

    public PuzzleFrame() {
        super("15 Puzzle");
        add(new PuzzlePanel());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
