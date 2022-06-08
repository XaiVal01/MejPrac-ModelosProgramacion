import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Linea implements Observer{

    private final int x0, y0, x1, y1;

    public Linea(int x0, int y0, int x1, int y1){
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void update(BufferedImage buff) {
        Color color = Color.BLACK;

        float adyacente = (float)Float.max(x0, x1) - Float.min(x0, x1);
        float opuesto = (float)Float.max(y0, y1) - Float.min(y0, y1);
        float pendiente = (float)opuesto / adyacente;

        int nextX = 0;
        int nextY = 0;
        pendiente = Math.abs(pendiente);

        if (x0 < x1) {
            nextX = 1;
        } else {
            nextX = -1;
        }

        if (y0<y1) {
            nextY = 1;
        } else{
            nextY = -1;
        }

        if (Math.toDegrees(Math.atan(pendiente)) > 45) {
            pendiente = (float)Math.abs(adyacente / opuesto);
            for (int i=0; i<=Math.abs(opuesto); i++) {
                buff.setRGB(x0 + (int)(i * pendiente * nextX), y0 + (i * nextY), color.getRGB());
            }
        } else{
            for (int j=0; j<=Math.abs(adyacente); j++) {
                buff.setRGB(x0 + j * nextX, y0 + (int) (j * pendiente * nextY), color.getRGB());
            }
        }
    }
}
