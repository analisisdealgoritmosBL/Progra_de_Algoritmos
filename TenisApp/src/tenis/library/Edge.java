package tenis.library;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Saves information about the lines to be drawn
 * in a design.
 * @author Braulio Rivera
 */
public class Edge {
        private Figure _figure1;
        private Figure _figure2;
        private FigureType _kind;
        private int _curve;
        private int _thickness1;
        private Color _color;
        private Line2D line = new Line2D.Float();
        QuadCurve2D _Curve = new QuadCurve2D.Float();

        public Edge(Figure pFigure1, Figure pFigure2, FigureType pKind, int pCurve, int pThickness, Color pColor) {
            this._figure1 = pFigure1;
            this._figure2 = pFigure2;
            this._kind = pKind;
            this._curve = pCurve;
            this._thickness1 = pThickness;
            this._color = pColor;
        }

        public Edge() {
            this._figure1 = null;
            this._figure2 = null;
            this._kind = null;
            this._curve = 0;
            this._thickness1 = 0;
            this._color = null;
        }
        
        public void draw(Graphics2D g2) {
            Point _point1 = _figure1.getLocation();
            Point _point2 = _figure2.getLocation();
            g2.setColor(_color);
            Point pointCurve = new Point();
            if (this._kind == FigureType.Line)
            {           
                g2.drawLine(_point1.x, _point1.y, _point2.x, _point2.y);
                g2.setStroke(new BasicStroke(this._thickness1));
            }
            else if (this._kind == FigureType.Curve) {
                
                if (_curve == 1){
                    pointCurve.setLocation(_point2.x-50, _point2.y-((_point2.y-_point1.y)/2));
                    this._Curve.setCurve(_point1,pointCurve,_point2);
                }
                else if (_curve == 2){
                    pointCurve.setLocation(_point2.x-((_point2.x-_point1.x)/2),_point2.y+50);
                    this._Curve.setCurve(_point1,pointCurve,_point2);
                }
                g2.draw(_Curve);
                
            }
            
            //g2.setStroke(new BasicStroke (this._thickness1));
        }
        
        public List <Point> intersect1(List<Edge> list) 
        {
            List <Point> points1 = new ArrayList();
            for (Edge n : list) 
            {
                points1.add(n._figure1.getLocation());
            }
            return points1;
        }
        public List <Point> intersect2(List<Edge> list) 
        {
            List <Point> points2 = new ArrayList();
            for (Edge n : list) 
            {
                points2.add(n._figure2.getLocation());
            }
            return points2;
        }
        
        
        public void updateThickness(List<Edge> list, int thickness) 
        {
            for (Edge n : list) 
            {
                if (n._figure1.isSelected() && n._figure2.isSelected()) 
                {
                    n._thickness1 = thickness;
                }
            }
        }
}
