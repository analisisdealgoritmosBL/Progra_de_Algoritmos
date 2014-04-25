/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JColorChooser;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import tenis.library.Figure_Kind;

/**
 *
 * @author Rodrigo
 */
public class EditorPainter implements LogicController
{
    
    
    @Override
    public void pintar(Design pDesign) {
        
    }
    public static void paint (Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        //new Color(0x00f0f0f0)
        for (Edge e :_edges) {
            e.draw(g2);
        }
        for (Figure n : _nodes){
            n.draw(g2);
        }
        if (_selecting) {
            g.setColor(Color.darkGray);
            g.drawRect(_mouseRect.x, _mouseRect.y,
                _mouseRect.width, _mouseRect.height);
        }
        
    }
    
    public static void nameDesign(String pName){
        _name = pName;
    }
    
    public static void firsthDesign() 
    {
        Point point1 = new Point(212,128);
        Point point2 = new Point(212,323);
        Point point3 = new Point(448,128);
        Point point4 = new Point(581,218);
        Point point5 = new Point(680,323);
        Point curve1 = new Point(150,175);
        Point curve2 = new Point(330,170);
        Figure.firsthDesignPoints(point1,Figure_Kind.Point,_radius,_nodes);
        Figure.firsthDesignPoints(point2,Figure_Kind.Point,_radius,_nodes);
        Figure.firsthDesignPoints(point3,Figure_Kind.Point,_radius,_nodes);
        Figure.firsthDesignPoints(point4,Figure_Kind.Point,_radius,_nodes);
        Figure.firsthDesignPoints(point5,Figure_Kind.Point,_radius,_nodes);
        
        Figure n0 = _nodes.get(0);
        Figure n1 = _nodes.get(1);
        Figure n2 = _nodes.get(2);
        Figure n3 = _nodes.get(3);
        Figure n4 = _nodes.get(4);
        _edges.add(new Edge(n2, n3,Figure_Kind.Line,0, _thickness));
        _edges.add(new Edge(n3, n4,Figure_Kind.Line,0, _thickness));
        _edges.add(new Edge(n1, n4,Figure_Kind.Line,0, _thickness));
        _edges.add(new Edge(n0, n1,Figure_Kind.Curve,1, _thickness));
        _edges.add(new Edge(n0, n2,Figure_Kind.Curve,2, _thickness));
    }
    
    public static void putColor(Component component){
        Color color = null;
        color = JColorChooser.showDialog(component, "Choose a color", color);
        if (color != null) {
            Figure.updateColor(EditorPainter.getListFigures(), color);
            
        }
    }
    
    public static void drawLine() 
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Point point1 = new Point ((WIDE/2)+50, (HIGH/2)+50);
        Figure.lines(point, point1, _radiusLine, Figure_Kind.Point,Figure_Kind.Line,_nodes,_edges);
    }
    
    public static void drawCircle()
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Figure.circle(point, _radiusCircle, _thickness, Figure_Kind.Circle,_nodes);
    }
    
    
    public static void drawPoint()
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Figure.firsthDesignPoints(point,Figure_Kind.Point,_radiusPoint,_nodes);
    }
    
    public static void UpdateRadius(int pValue){
        int radius;
        radius = pValue;
        Figure.updateRadius(_nodes, radius);
    }
    public static List<Figure> getListFigures (){
        return _nodes;
    }
    public static List<Edge> getListEdges (){
        return _edges;
    }
    
    public static Point getMousePt() {
        return _mousePt;
    }

    public static Rectangle getMouseRect() {
        return _mouseRect;
    }

    public Rectangle getMouseBounds() {
        return _mouseBounds;
    }

    public static boolean isSelecting() {
        return _selecting;
    }

    public static int getRadius() {
        return _radius;
    }

    public static int getRadiusPoint() {
        return _radiusPoint;
    }

    public static int getRadiusCircle() {
        return _radiusCircle;
    }

    public static int getRadiusLine() {
        return _radiusLine;
    }

    public static String getName() {
        return _name;
    }
    public static void setMousePt(Point _mousePt) {
        EditorPainter._mousePt = _mousePt;
    }
    public static void setSelecting(boolean _selecting) {
        EditorPainter._selecting = _selecting;
    }
    
    private static final int WIDE = 640;
    private static final int HIGH = 480;
    private static Point _mousePt = new Point(WIDE / 2, HIGH / 2);
    private static Rectangle _mouseRect = new Rectangle();
    private Rectangle _mouseBounds = new Rectangle(200,200,300,300);
    private static boolean _selecting = false;
    private static final int _radius = 15;
    private static final int _radiusPoint = 10;
    private static final int _thickness = 1;
    private static final int _radiusCircle = 15;
    private static final int _radiusLine = 3;
    private static List<Figure> _nodes = new ArrayList<>();
    private static List<Edge> _edges = new ArrayList<>();
    private static String _name;
    
}

