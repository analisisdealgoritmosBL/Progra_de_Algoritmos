/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import tenis.library.Figure_Kind;
import tenis.library.Proram_Mode;

/**
 *
 * @author Rodrigo
 */
public class PaintAdministrator 
{
    

    private PaintAdministrator() 
    {
        _Painters = new Hashtable<Proram_Mode, LogicController>();
        _Painters.put(Proram_Mode.EDIT, new EditorPainter());
        _Painters.put(Proram_Mode.ARCADE, new ArcadePainter());
        _Painters.put(Proram_Mode.FIRE, new FirePainter());
    }
    
    public synchronized static PaintAdministrator getInstance() 
    {
        if (_PainterLogic==null)
        {
            _PainterLogic = new PaintAdministrator();
        }
        return _PainterLogic;
    }
    
    
    public void cargarDiseno(Design pDesino) 
    {
        LogicController painter = _Painters.get(_ModeType);
        painter.pintar(pDesino);
    }
    
    public void setMode(Proram_Mode pMode)
    {
        _ModeType = pMode;
    }
    
    public static void nameDesign(String pName) 
    {
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
    
    
    private static final int WIDE = 640;
    private static final int HIGH = 480;
    private static final int _radius = 15;
    private static final int _radiusPoint = 10;
    private static final int _thickness = 1;
    private static final int _radiusCircle = 15;
    private static final int _radiusLine = 3;
    public static List<Figure> _nodes = new ArrayList<>();
    public static List<Edge> _edges = new ArrayList<>();
    public static String _name;
    private Proram_Mode _ModeType;
    private static PaintAdministrator _PainterLogic;
    private Dictionary<Proram_Mode, LogicController> _Painters;
}