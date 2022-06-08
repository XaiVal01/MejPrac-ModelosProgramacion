import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends JFrame {

    private BufferedImage buffer;
    private Graphics graPixel;

    public static void main(String[] args) {
       Singleton s = Singleton.getInstance();
       s.init();
    }
}
