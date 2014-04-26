package tenis.library;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class Background {
    
    private Figure _BackgroundFigure1;
    private Color _BackgroundColor;
    private Figure_Kind _Backgroundkind;
    
    public Background(Figure pFigure1, Color pBackgroundColor, Figure_Kind pKind) {
        this._BackgroundFigure1 = pFigure1;
        this._BackgroundColor = pBackgroundColor;
        this._Backgroundkind = pKind;
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

    public Figure_Kind getBackgroundkind() {
        return _Backgroundkind;
    }

    public void setBackgroundkind(Figure_Kind _Backgroundkind) {
        this._Backgroundkind = _Backgroundkind;
    }
    
    
    
    
}
