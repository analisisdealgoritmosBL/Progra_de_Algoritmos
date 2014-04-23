package tenis.library;

import java.awt.Color;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class Background {
    private int _BackgroundCoordinateX;
    private int _BackgroundCoordinateY;
    private int _BackgroundColor;
    
    public Background(int pBackgroundCoordinateX, int pBackgroundCoordinateY, Color pBackgroundColor) {
        
    }

    public int getBackgroundCoordinateX() {
        return _BackgroundCoordinateX;
    }

    public void setBackgroundCoordinateX(int pBackgroundCoordinateX) {
        _BackgroundCoordinateX = pBackgroundCoordinateX;
    }

    public int getBackgroundCoordinateY() {
        return _BackgroundCoordinateY;
    }

    public void setBackgroundCoordinateY(int pBackgroundCoordinateY) {
        _BackgroundCoordinateY = pBackgroundCoordinateY;
    }

    public int getBackgroudColor() {
        return _BackgroundColor;
    }

    public void setBackgroudColor(int pBackgroudColor) {
        _BackgroundColor = pBackgroudColor;
    }
    
}
