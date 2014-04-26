package tenis.library;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

/**
 * Saves information about the color a background is
 * going to be painted with.
 * @author Braulio Rivera
 */
public class Background {
    
    private Figure _BackgroundFigure1;
    private Color _BackgroundColor;
    private FigureType _BackgroundKind;
    
    public Background(Figure pFigure1, Color pBackgroundColor, FigureType pKind) {
        this._BackgroundFigure1 = pFigure1;
        this._BackgroundColor = pBackgroundColor;
        this._BackgroundKind = pKind;
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(_BackgroundFigure1.getColor());
        g2.fillOval(_BackgroundFigure1.getLocation().x, _BackgroundFigure1.getLocation().y, _BackgroundFigure1.getRadius()*2,_BackgroundFigure1.getRadius()*2);
    }

    public Figure getBackgroundFigure1() {
        return _BackgroundFigure1;
    }

    public void setBackgroundFigure1(Figure _BackgroundFigure1) {
        this._BackgroundFigure1 = _BackgroundFigure1;
    }

    public Color getBackgroundColor() {
        return _BackgroundColor;
    }

    public void setBackgroundColor(Color _BackgroundColor) {
        this._BackgroundColor = _BackgroundColor;
    }

    public FigureType getBackgroundKind() {
        return _BackgroundKind;
    }

    public void setBackgroundKind(FigureType _BackgroundKind) {
        this._BackgroundKind = _BackgroundKind;
    }
    
    
    
    
}
