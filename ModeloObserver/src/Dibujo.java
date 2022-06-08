import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Dibujo extends JFrame implements Observable{

    private BufferedImage buffer;
    private Graphics graPixel;
    private final ArrayList<Observer> observers;

    public Dibujo() {
        observers = new ArrayList<Observer>();

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamPanatalla = miPantalla.getScreenSize();
        int pantallaWidth = tamPanatalla.width;
        int pantallaHeight = tamPanatalla.height;

        setSize(pantallaWidth/2, pantallaHeight/2);
        setLocation(pantallaWidth/4, pantallaHeight/4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void addObserver(Observer dibujo) {observers.add(dibujo);}

    //@Override
    //public void removeObserver(Observer dibujo) {observers.remove(dibujo);}

    @Override
    public void dibujar() {
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        graPixel = buffer.createGraphics();

        for (Observer dibujo:observers){
            dibujo.update(buffer);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(buffer, 50, 50, this);
    }
}
