package image15;

import java.awt.image.BufferedImage;

public class PuzzlePiece {

    private final int value;
    private final BufferedImage image;

    public PuzzlePiece(int value, BufferedImage image) {
        this.value = value;
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public BufferedImage getImage() {
        return image;
    }
}
