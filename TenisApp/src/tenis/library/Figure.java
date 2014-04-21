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
    
    
        private int x1;
        private int x2;
        private int x3;
        private int x4;
        private Point point1;
        private Point curve;
        private Point point2;
        private Point p;
        private int r;
        private Color color;
        private Figure_Kind kind;
        private boolean selected = false;
        private Rectangle b = new Rectangle();
        

        /**
         * Construct a new node.
         */
        public Figure(Point p, int r, Color color, Figure_Kind kind) {
            this.p = p;
            this.r = r;
            this.color = color;
            this.kind = kind;
            setBoundary(b);
        }
        public Figure(int x1, int x2, int x3, int x4, Figure_Kind kind) {
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.x4 = x4;
            this.kind = kind;
        }
        public Figure(Point point1,Point curve,Point point2, Figure_Kind kind) {
            this.point1 = point1;
            this.curve = curve;
            this.point2 = point2;
            this.kind = kind;
        }

        /**
         * Calculate this node's rectangular boundary.
         */
        private void setBoundary(Rectangle b) {
            b.setBounds(p.x - r, p.y - r, 2 * r, 2 * r);
        }

        /**
         * Draw this node.
         */
        public void draw(Graphics g) {
            QuadCurve2D q = new QuadCurve2D.Float();
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(this.color);
            if (this.kind == Figure_Kind.Circular) {
                g.fillOval(b.x, b.y, b.width, b.height);
            } 
            else if (this.kind == Figure_Kind.Line) {
                g.drawLine(this.x1, this.x2, this.x3, this.x4);
            } 
            else if (this.kind == Figure_Kind.Curve) {
                q.setCurve(this.point1, this.curve, this.point2);
                g2.draw(q);
            }
            if (selected) {
                g.setColor(Color.darkGray);
                g.drawRect(b.x, b.y, b.width, b.height);
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
        public static void updateRadius(List<Figure> list, int r) {
            for (Figure n : list) {
                if (n.isSelected()) {
                    n.r = r;
                    n.setBoundary(n.b);
                }
            }
        }

        /**
         * Update each node's color.
         */
        public static void updateColor(List<Figure> list, Color color) {
            for (Figure n : list) {
                if (n.isSelected()) {
                    n.color = color;
                }
            }
        }

        /**
         * Update each node's kind.
         */
        public static void updateFigure_Kind(List<Figure> list, Figure_Kind kind) {
            for (Figure n : list) {
                if (n.isSelected()) {
                    n.kind = kind;
                }
            }
        }
}


