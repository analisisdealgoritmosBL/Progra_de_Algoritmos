package tenis.library;

import java.awt.Color;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class Background {
    private int _BackgroundCoordinateX;
    private int _BackgroundCoordinateY;
    private Color _BackgroundColor;
    
    public Background(int pBackgroundCoordinateX, int pBackgroundCoordinateY, Color pBackgroundColor) {
        setBackgroundCoordinateX(pBackgroundCoordinateX);
        setBackgroundCoordinateY(pBackgroundCoordinateY);
        setBackgroundColor(pBackgroundColor);
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

    public Color getBackgroundColor() {
        return _BackgroundColor;
    }

    public void setBackgroundColor(Color pBackgroundColor) {
        _BackgroundColor = pBackgroundColor;
    }
    
}
