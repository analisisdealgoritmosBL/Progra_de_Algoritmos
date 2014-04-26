/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.library;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.util.List;

/**
 *
 * @author Braulio Rivera
 */

public class Figure {
    
    
        private Point p;
        private int r;
        private int thickness;
        private static final int _thicknessLine = 1;
        private Color color;
        private Figure_Kind kind;
        private boolean selected = false;
        private Rectangle b = new Rectangle();
        private Rectangle u = new Rectangle();
        

        /**
         * Construct a new node.
         */
        public Figure(Point p, int r, Color color, Figure_Kind kind, int thickness) {
            this.p = p;
            this.r = r;
            this.color = color;
            this.kind = kind;
            this.thickness = thickness;
            setBoundary(b);
            //setPosBounds(u);
        }
       
        /**
         * Calculate this node's rectangular boundary.
         */
        private void setBoundary(Rectangle b) {
            b.setBounds(p.x - r, p.y - r, 2 * r, 2 * r);
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
            if (this.kind == Figure_Kind.Point) {
                g2.fillOval(b.x, b.y, b.width, b.height);
            }
            else if (this.kind == Figure_Kind.Circle) {
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
            return p;
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
                n.setSelected(r.contains(n.p));
            }
        }

        /**
         * Toggle selected state of each node containing p.
         */
        public static void selectToggle(List<Figure> list, Point p) {
            for (Figure n : list) {
                if (n.contains(p)) {
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
                    n.p.x += d.x;
                    n.p.y += d.y;
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
                    n.r = pRadPoint;
                    n.setBoundary(n.b);
                }
            }
        }
        
        public static void updateRadius(Figure point, int pRadPoint) {
            point.r = pRadPoint;
            point.setBoundary(point.b);
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
        
        public static boolean RectIntersect(List<Figure> list) 
        {
            for (Figure n : list) 
            {
                if (n.isSelected()) 
                {
                    if (n.b.intersects(n.u)){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
            return false;
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

        
        public static void firsthDesignPoints(Point mousePt, Figure_Kind kind, int radius, List<Figure> nodes) 
        {
            Figure.selectNone(nodes);
            Point p = mousePt.getLocation();
            Figure n = new Figure(p, radius, Color.blue, kind, 0);
            n.setSelected(true);
            nodes.add(n);
        }
        public static void lines(Point mousePt1, Point mousePt2, int radius, Figure_Kind kindPoint, Figure_Kind kindLine, List<Figure> nodes, List<Edge> edges) 
        {
            Figure.selectNone(nodes);
            Figure n = new Figure(mousePt1, radius, Color.BLACK, kindPoint, 0);
            Figure n1 = new Figure(mousePt2, radius, Color.BLACK, kindPoint, 0);
            edges.add(new Edge(n, n1, kindLine, 0, _thicknessLine, Color.black));
            n.setSelected(true);
            nodes.add(n);
            nodes.add(n1);
        }
        public static void circle(Point mousePt,  int radius, int thickness, Figure_Kind kind, List<Figure> nodes) 
        {
            Figure.selectNone(nodes);
            Point p = mousePt.getLocation();
            Figure n = new Figure(p, radius, Color.green, kind, thickness);
            n.setSelected(true);
            nodes.add(n);
        }
    
        
    
}