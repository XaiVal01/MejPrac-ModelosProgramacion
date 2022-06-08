//Dibujo

import java.awt.*;

interface Observable {
    void addObserver( Observer observer );
    //public void removeObserver( Observer observer );
    void dibujar();
}
