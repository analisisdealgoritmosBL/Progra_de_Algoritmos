/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import tenis.library.Program_Mode;
import static tenis.logic.PaintAdministrator.firstDesign;
import static tenis.logic.PaintAdministrator.getEdges;
import static tenis.logic.PaintAdministrator.getNodes;

/**
 *
 * @author Rodrigo
 */
public class PaintAdministrator 
{
    

    private PaintAdministrator() 
    {
        _Painters.put(Program_Mode.EDIT, new EditorPainter());
        _Painters.put(Program_Mode.ARCADE, new ArcadePainter());
        _Painters.put(Program_Mode.FIRE, new FirePainter());
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
    
    public void setMode(Program_Mode pMode)
    {
        _ModeType = pMode;
    }
    
    public static void nameDesign(String pName) 
    {
        EditorPainter.nameDesign(pName);
    }
    
    public static void firstDesign() 
    {
        EditorPainter.firstDesign();
    }
    
    public static void drawLine() 
    {
        EditorPainter.drawLine();
    }
    
    public static void drawCircle()
    {
        EditorPainter.drawCircle();
    }
    
    public static void drawPoint()
    {
        EditorPainter.drawPoint();
    }
    public static void UpdateCircle(int pValue)
    {
        EditorPainter.UpdateRadius(pValue);
    }

    public static Point getMousePt() {
        return _mousePt;
    }

    public static void setMousePt(Point _mousePt) {
        PaintAdministrator._mousePt = _mousePt;
    }

    public static Rectangle getMouseRect() {
        return _mouseRect;
    }

    public static void setMouseRect(Rectangle _mouseRect) {
        PaintAdministrator._mouseRect = _mouseRect;
    }

    public Rectangle getMouseBounds() {
        return _mouseBounds;
    }

    public void setMouseBounds(Rectangle _mouseBounds) {
        this._mouseBounds = _mouseBounds;
    }

    public static boolean isSelecting() {
        return _selecting;
    }

    public static void setSelecting(boolean _selecting) {
        PaintAdministrator._selecting = _selecting;
    }

    public static List<Figure> getNodes() {
        return _nodes;
    }

    public static void setNodes(List<Figure> _nodes) {
        PaintAdministrator._nodes = _nodes;
    }

    public static List<Edge> getEdges() {
        return _edges;
    }

    public static void setEdges(List<Edge> _edges) {
        PaintAdministrator._edges = _edges;
    }

    public static String getName() {
        return _name;
    }

    public static void setName(String _name) {
        PaintAdministrator._name = _name;
    }
    public static void clear(){
        getNodes().clear();
        getEdges().clear();
        getBackgrounds().clear();
        firstDesign();
    }

    public static int getRadius() {
        return _radius;
    }

    public static void setRadius(int _radius) {
        PaintAdministrator._radius = _radius;
    }

    public static int getRadiusPoint() {
        return _radiusPoint;
    }

    public static void setRadiusPoint(int _radiusPoint) {
        PaintAdministrator._radiusPoint = _radiusPoint;
    }

    public static int getThickness() {
        return _thickness;
    }

    public static void setThickness(int _thickness) {
        PaintAdministrator._thickness = _thickness;
    }

    public static int getRadiusCircle() {
        return _radiusCircle;
    }

    public static void setRadiusCircle(int _radiusCircle) {
        PaintAdministrator._radiusCircle = _radiusCircle;
    }

    public static int getRadiusLine() {
        return _radiusLine;
    }

    public static void setRadiusLine(int _radiusLine) {
        PaintAdministrator._radiusLine = _radiusLine;
    }
    
    public static List<Point> getCurvePoints() {
        return _curvePoints;
    }
    public static List<Background> getBackgrounds() {
        return _Backgrounds;
    }

    public static void setBackgrounds(List<Background> _Backgrounds) {
        PaintAdministrator._Backgrounds = _Backgrounds;
    }
    
    private Program_Mode _ModeType;
    private static PaintAdministrator _PainterLogic;
    private Dictionary<Program_Mode, LogicController> _Painters;
    
    private static final int WIDE = 640;
    private static final int HIGH = 480;
    private static Point _mousePt = new Point(WIDE / 2, HIGH / 2);
    private static Rectangle _mouseRect = new Rectangle();
    private Rectangle _mouseBounds = new Rectangle(200,200,300,300);
    private static boolean _selecting = false;
    private static int _radius = 10;
    private static int _radiusPoint = 10;
    private static int _thickness = 1;
    private static int _radiusCircle = 15;
    private static int _radiusLine = 5;
    private static List<Figure> _nodes = new ArrayList<>();
    private static List<Edge> _edges = new ArrayList<>();
    private static List<Background> _Backgrounds = new ArrayList<>();
    private static List<Point> _curvePoints = Edge.getcurvePoints();
    private static String _name;
}