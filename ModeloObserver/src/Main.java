import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Graphics graPixel;

        Dibujo dibujo = new Dibujo();

        Linea linea1 = new Linea(20, 20, 120, 120);
        Linea linea2 = new Linea(130, 70, 270, 70);
        Linea linea3 = new Linea(400, 20, 300, 120);
        Linea linea4 = new Linea(550,70 , 410, 70);

        Circulo circulo1 = new Circulo(300, 250, 100);
        Circulo circulo2 = new Circulo(300, 250, 80);
        Circulo circulo3 = new Circulo(300, 250, 60 );
        Circulo circulo4 = new Circulo(300, 250, 40);
        Circulo circulo5 = new Circulo(300, 250, 20);

        dibujo.addObserver(linea1);
        dibujo.addObserver(linea2);
        dibujo.addObserver(linea3);
        dibujo.addObserver(linea4);
        dibujo.addObserver(circulo1);
        dibujo.addObserver(circulo2);
        dibujo.addObserver(circulo3);
        dibujo.addObserver(circulo4);
        dibujo.addObserver(circulo5);

        dibujo.dibujar();
    }

}
