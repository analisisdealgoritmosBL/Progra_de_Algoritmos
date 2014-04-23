/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.library;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import java.util.List;

/**
 *
 * @author Braulio Rivera
 */
public class Edge {
        private Figure _figure1;
        private Figure _figure2;
        private Figure_Kind _kind;
        private int _curve;
        private int _thickness1;

        public Edge(Figure pFigure1, Figure pFigure2, Figure_Kind pkind, int pcurve, int thickness) {
            this._figure1 = pFigure1;
            this._figure2 = pFigure2;
            this._kind = pkind;
            this._curve = pcurve;
            this._thickness1 = thickness;
        }

        public void draw(Graphics2D g2) {
            QuadCurve2D q = new QuadCurve2D.Float();
            Point _point1 = _figure1.getLocation();
            Point _point2 = _figure2.getLocation();
            g2.setColor(Color.BLACK);
            if (this._kind == Figure_Kind.Line)
            {           
                g2.drawLine(_point1.x, _point1.y, _point2.x, _point2.y);
            }
            else if (this._kind == Figure_Kind.Curve) {
                if (_curve == 1){
                    Point pointCurve = new Point(_point2.x-50,_point2.y-((_point2.y-_point1.y)/2));
                    q.setCurve(_point1,pointCurve,_point2);
                }
                else if (_curve == 2){
                    Point pointCurve = new Point(_point2.x-((_point2.x-_point1.x)/2),_point2.y+50);
                    q.setCurve(_point1,pointCurve,_point2);
                }
                g2.draw(q);
            }
            //g2.setStroke(new BasicStroke (this._thickness1));
        }
        
        public static void updateThickness(List<Edge> list, int thickness) 
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
