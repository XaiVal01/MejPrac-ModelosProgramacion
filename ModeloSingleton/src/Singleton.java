import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Singleton extends JFrame{
    static private Singleton instance = new Singleton();

    private BufferedImage buffer;
    private Graphics graPixel;

    private Singleton(){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamPanatalla = miPantalla.getScreenSize();
        int pantallaWidth = tamPanatalla.width;
        int pantallaHeight = tamPanatalla.height;

        setSize(pantallaWidth/2, pantallaHeight/2);
        setLocation(pantallaWidth/4, pantallaHeight/4);
        setLayout(null);
    }

    private void DibujarPuntoMedioLineaMascara(int x1, int y1, int x2, int y2, int Grosor, BufferedImage bu) {
        int pk, a, b, pxlx, pxly;

        int dx = (x2 - x1);
        int dy = (y2 - y1);

        if (dy < 0) {
            dy = -dy;
            pxly = -1;
        }
        else {
            pxly = 1;
        }
        if (dx < 0) {
            dx = -dx;
            pxlx = -1;
        } else {
            pxlx = 1;
        }

        int x = x1;
        int y = y1;
        bu.setRGB(x1,y1, Color.BLACK.getRGB());

        if(dx>dy){
            pk = 2*dy - dx;
            a = 2*dy;
            b = 2*(dy-dx);
            while (x != x2){
                x = x + pxlx;
                if (pk < 0){
                    pk = pk + a;
                } else {
                    y = y + pxly + 1/2;
                    pk = pk + b;
                }
                for(int i = Grosor - 1; i > 0; i--) {
                    bu.setRGB(x, y, Color.BLACK.getRGB());
                    bu.setRGB(x-i, y, Color.BLACK.getRGB());
                    bu.setRGB(x, y-i, Color.BLACK.getRGB());
                    bu.setRGB(x, y+i, Color.BLACK.getRGB());
                    bu.setRGB(x+i, y, Color.BLACK.getRGB());
                }
            }
        } else {
            pk = 2*dx - dy;
            a = 2*dx;
            b = 2*(dx-dy);
            while (y != y2){
                y = y + pxly + 1/2;
                if (pk < 0){
                    pk = pk + a;
                } else {
                    x = x + pxlx;
                    pk = pk + b;
                }
                for(int i = Grosor - 1; i > 0; i--) {
                    bu.setRGB(x, y, Color.BLACK.getRGB());
                    bu.setRGB(x-i, y, Color.BLACK.getRGB());
                    bu.setRGB(x, y-i, Color.BLACK.getRGB());
                    bu.setRGB(x, y+i, Color.BLACK.getRGB());
                    bu.setRGB(x+i, y, Color.BLACK.getRGB());
                }
            }
        }
    }

    public void init(){
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();
        DibujarPuntoMedioLineaMascara(100, 100, 300, 300, 3, buffer);
        DibujarPuntoMedioLineaMascara(400, 100, 400, 400, 3, buffer);
        DibujarPuntoMedioLineaMascara(420, 200, 720, 200, 5, buffer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void init2(){System.out.println("quiubo");}

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(buffer, 0, 0, null);
    }

    public static Singleton getInstance(){
        return instance;
    }
}
