/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.library;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.util.List;

/**
 * Saves information about the figures (circles) that
 * can be drawn in a design.
 * @author Braulio Rivera
 */

public class Figure {
    
    
        private Point point;
        private int radius;
        private int thickness;
        private static final int _thicknessLine = 1;
        private Color color;

    
        private FigureType kind;
        private boolean selected = false;
        private Rectangle b = new Rectangle();
        

        /**
         * Construct a new node.
         */
        public Figure(Point pPoint, int pRadius, Color pColor, FigureType pKind, int pThickness) {
            this.point = pPoint;
            this.radius = pRadius;
            this.color = pColor;
            this.kind = pKind;
            this.thickness = pThickness;
            setBoundary(b);
            //setPosBounds(u);
        }
       
        /**
         * Calculate this node's rectangular boundary.
         */
        private void setBoundary(Rectangle b) {
            b.setBounds(point.x - radius, point.y - radius, 2 * radius, 2 * radius);
        }
        /*private void setPosBounds(Rectangle u) {
            u.setBounds(b.x-50, b.y-50, b.height*2, b.width*2);
        }*/

        /**
         * Draw this node.
         */
        public void draw(Graphics2D g2) {
            QuadCurve2D q = new QuadCurve2D.Float();
            g2.setColor(this.color);
            if (this.kind == FigureType.Point) {
                g2.fillOval(b.x, b.y, b.width, b.height);
            }
            else if (this.kind == FigureType.Circle) {
                g2.drawOval(b.x, b.y, b.width, b.height);
            }
            if (selected) {
                g2.setColor(Color.darkGray);
                g2.drawRect(b.x, b.y, b.width, b.height);
            }
        }

        /**
         * Return this node's location.
         */
        public Point getLocation() {
            return point;
        }
        public Color getColor() {
            return color;
        }
        public int getRadius() {
            return radius;
        }

        /**
         * Return true if this node contains p.
         */
        public boolean contains(Point p) {
            return b.contains(p);
        }
        
        /*public static boolean intersects(List<Figure> pList, List<Edge> pEdges ) {
            for (Figure n : pList) {
                if (n.isSelected()) {
                    return n.b.intersectsLine();
                }
            }
            return false;
        }*/

        /**
         * Return true if this node is selected.
         */
        public boolean isSelected() {
            return selected;
        }

        /**
         * Mark this node as selected.
         */
        public void setSelected(boolean selected) {
            this.selected = selected;
        }
        
        /**
         * Collected all the selected nodes in list.
         */
        public static void getSelected(List<Figure> list, List<Figure> selected) {
            selected.clear();
            for (Figure n : list) {
                if (n.isSelected()) {
                    selected.add(n);
                }
            }
        }
        
        /**
         * Select no nodes.
         */
        public static void selectNone(List<Figure> list) {
            for (Figure n : list) {
                n.setSelected(false);
            }
        }

        /**
         * Select a single node; return true if not already selected.
         */
        public static boolean selectOne(List<Figure> list, Point p) {
            for (Figure n : list) {
                if (n.contains(p)) {
                    if (!n.isSelected()) {
                        Figure.selectNone(list);
                        n.setSelected(true);
                    }
                    return true;
                }
            }
            return false;
        }

        /**
         * Select each node in r.
         */
        public static void selectRect(List<Figure> list, Rectangle r) {
            for (Figure n : list) {
                n.setSelected(r.contains(n.point));
            }
        }

        /**
         * Toggle selected state of each node containing p.
         */
        public static void selectToggle(List<Figure> list, Point pointSearch) {
            for (Figure n : list) {
                if (n.contains(pointSearch)) {
                    n.setSelected(!n.isSelected());
                }
            }
        }

        /**
         * Update each node's position by d (delta).
         */
        public static void updatePosition(List<Figure> list, Point d) {
            for (Figure n : list) {
                if (n.isSelected()) {
                    n.point.x += d.x;
                    n.point.y += d.y;
                    n.setBoundary(n.b);
                }
            }
        }

        /**
         * Update each node's radius r.
         */
        public static void updateRadius(List<Figure> list, int pRadPoint) {
            for (Figure n : list) {
                if (n.isSelected()) {
                    n.radius = pRadPoint;
                    n.setBoundary(n.b);
                }
            }
        }
        public static void updateRadius1(List<Figure> list, int pRadPoint) {
            for (Figure n : list) {
                n.radius = pRadPoint;
                n.setBoundary(n.b);
            }            
        }
        

        /**
         * Update each node's color.
         */
        public static void updateColor(List<Figure> list, Color color) 
        {
            for (Figure n : list) 
            {
                if (n.isSelected()) 
                {
                    n.color = color;
                }
            }
        }
        
               
        /*public static void updateThickness(List<Figure> list, int thickness) 
        {
            for (Figure n : list) 
            {
                if (n.isSelected()) 
                {
                    n.thickness = thickness;
                }
            }
        }*/

        
        public static void firstDesignPoints(Point mousePt, FigureType kind, int radius, List<Figure> nodes) 
        {
            Figure.selectNone(nodes);
            Point p = mousePt.getLocation();
            Figure n = new Figure(p, radius, Color.blue, kind, 0);
            n.setSelected(true);
            nodes.add(n);
        }
        
        public static void Points(Point mousePt, FigureType kind, int radius, List<Figure> nodes, List<Background> Backgroundnodes) 
        {
            Figure.selectNone(nodes);
            Point p = mousePt.getLocation();
            Figure n = new Figure(p, radius, Color.green, kind, 0);
            Backgroundnodes.add(new Background(n,kind));
            n.setSelected(true);
            nodes.add(n);
        }
        
        public static void lines(Point mousePt1, Point mousePt2, int radius, FigureType kindPoint, FigureType kindLine, List<Figure> nodes, List<Edge> edges) 
        {
            Figure.selectNone(nodes);
            Figure n = new Figure(mousePt1, radius, Color.BLACK, kindPoint, 0);
            Figure n1 = new Figure(mousePt2, radius, Color.BLACK, kindPoint, 0);
            edges.add(new Edge(n, n1, kindLine, 0, _thicknessLine, Color.black));
            n.setSelected(true);
            nodes.add(n);
            nodes.add(n1);
        }
        public static void circle(Point mousePt,  int radius, int thickness, FigureType kind, List<Figure> nodes) 
        {
            Figure.selectNone(nodes);
            Point p = mousePt.getLocation();
            Figure n = new Figure(p, radius, Color.green, kind, thickness);
            n.setSelected(true);
            nodes.add(n);
        }
    
        
    
}