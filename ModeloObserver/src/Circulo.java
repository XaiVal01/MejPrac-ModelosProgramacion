import java.awt.*;
import java.awt.image.BufferedImage;

public class Circulo implements Observer{

    private final int xCent, yCent;
    private int r;

    public Circulo(int xCent, int yCent, int r){
        this.xCent = xCent;
        this.yCent = yCent;
        this.r = r;
    }

    @Override
    public void update(BufferedImage buff) {
        int x = -r;
        int y = 0;
        int error = 2 - 2 * r;

        do {
            buff.setRGB(xCent - x, yCent + y, Color.BLACK.getRGB());
            buff.setRGB(xCent - y, yCent - x, Color.BLACK.getRGB());
            buff.setRGB(xCent + x, yCent - y, Color.BLACK.getRGB());
            buff.setRGB(xCent + y, yCent + x, Color.BLACK.getRGB());

            r = error;
            if (r > x) {
                error += ++x * 2 + 1;
            }
            if (r <= y) {
                error += ++y * 2 + 1;
            }
        } while (x < 0);
    }
}
