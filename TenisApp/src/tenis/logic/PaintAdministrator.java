/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import tenis.library.Program_Mode;
//import tenis.logic.PaintAdministrator.firstDesign;
//import tenis.logic.PaintAdministrator.getEdges;
//import tenis.logic.PaintAdministrator.getNodes;

public class PaintAdministrator 
{

    public void paint(Graphics p, Program_Mode pMode){

        switch(pMode){
                case EDIT: 
                    _Editor.paint(p, _nodes, _edges, _mouseRect, _selecting); 
                    break;
                case FIRE:
                    _Editor.paint(p, _nodes, _edges, _mouseRect, _selecting);
                    FirePainter.Algorithm(p);
                    break;
                case ARCADE:
                    //ArcadePainter.Algorithm(g);
                    break;
        }    
    }

    public void dragNode(MouseEvent evt) {
        Point delta = new Point();
        //if (!Figure.RectIntersect(PaintAdministrator.getListFigure())){
            
        //}
        if (_selecting) {

        //if (Figure.colitions(PaintAdministrator.getListFigure(), PaintAdministrator._edges)){
            _mouseRect.setBounds(
                Math.min(_mousePt.x, evt.getX()),
                Math.min(_mousePt.y, evt.getY()),
                Math.abs(_mousePt.x - evt.getX()),
                Math.abs(_mousePt.y - evt.getY()));
            Figure.selectRect(_nodes, _mouseRect);
        //}
        }
        
        
        else {
            delta.setLocation(
                evt.getX() - _mousePt.x,
                evt.getY() - _mousePt.y);
            
                Figure.updatePosition(_nodes, delta);
            
            _mousePt = evt.getPoint();
        }
    }

    public void Press(MouseEvent evt) {
        _mousePt = evt.getPoint();
        if (evt.isShiftDown()) {
            Figure.selectToggle(_nodes, _mousePt);
        } else if (evt.isPopupTrigger()) {
            Figure.selectOne(_nodes, _mousePt);
            //showPopup(evt);
        } else if (Figure.selectOne(_nodes, _mousePt)) {
            _selecting =false;
        } else {
            Figure.selectNone(_nodes);
            _selecting = true;
        }    }

    public void Release(MouseEvent evt) {
        _selecting = false;
        _mouseRect.setBounds(0, 0, 0, 0);
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
    
    /*public void nameDesign(String pName) 
    {
        _Editor.nameDesign(pName);
    }*/
    
    public void firstDesign() 
    {
        _Editor.firstDesign(_nodes, _edges, _radius , _thickness);
    }
    
    public void drawLine() 
    {
        _Editor.drawLine(_radiusLine, _nodes, _edges);
    }
    
    public void drawCircle()
    {
        _Editor.drawCircle(_radiusCircle , _nodes, _thickness);
    }
    
    public void drawPoint()
    {
        _Editor.drawPoint(_radiusPoint , _nodes, _Backgrounds);
    }
    public void UpdateCircle(int pValue)
    {
        _Editor.UpdateRadius(pValue, _nodes);
    }
    
    public void clear(){
        _nodes.clear();
        _edges.clear();
        _Backgrounds.clear();
        firstDesign();
    }
    public Program_Mode getModeType() {
        return _ModeType;
    }

    public void setModeType(Program_Mode _ModeType) {
        this._ModeType = _ModeType;
    }

    public Point getMousePt() {
        return _mousePt;
    }

    public void setMousePt(Point _mousePt) {
        this._mousePt = _mousePt;
    }

    public Rectangle getMouseRect() {
        return _mouseRect;
    }

    public void setMouseRect(Rectangle _mouseRect) {
        this._mouseRect = _mouseRect;
    }

    public Rectangle getMouseBounds() {
        return _mouseBounds;
    }

    public void setMouseBounds(Rectangle _mouseBounds) {
        this._mouseBounds = _mouseBounds;
    }

    public boolean isSelecting() {
        return _selecting;
    }

    public void setSelecting(boolean _selecting) {
        this._selecting = _selecting;
    }

    public int getRadius() {
        return _radius;
    }

    public void setRadius(int _radius) {
        this._radius = _radius;
    }

    public int getRadiusPoint() {
        return _radiusPoint;
    }

    public void setRadiusPoint(int _radiusPoint) {
        this._radiusPoint = _radiusPoint;
    }

    public int getThickness() {
        return _thickness;
    }

    public void setThickness(int _thickness) {
        this._thickness = _thickness;
    }

    public int getRadiusCircle() {
        return _radiusCircle;
    }

    public void setRadiusCircle(int _radiusCircle) {
        this._radiusCircle = _radiusCircle;
    }

    public int getRadiusLine() {
        return _radiusLine;
    }

    public void setRadiusLine(int _radiusLine) {
        this._radiusLine = _radiusLine;
    }

    public List<Figure> getNodes() {
        return _nodes;
    }

    public void setNodes(List<Figure> _nodes) {
        this._nodes = _nodes;
    }

    public List<Edge> getEdges() {
        return _edges;
    }

    public void setEdges(List<Edge> _edges) {
        this._edges = _edges;
    }

    public List<Background> getBackgrounds() {
        return _Backgrounds;
    }

    public void setBackgrounds(List<Background> _Backgrounds) {
        this._Backgrounds = _Backgrounds;
    }

    public List<Point> getCurvePoints() {
        return _curvePoints;
    }

    public void setCurvePoints(List<Point> _curvePoints) {
        this._curvePoints = _curvePoints;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }
    
    private Program_Mode _ModeType;
    private static PaintAdministrator _PainterLogic;
    private Dictionary<Program_Mode, LogicController> _Painters;
    private EditorPainter _Editor = new EditorPainter();
    private final int WIDE = 640;
    private final int HIGH = 480;
    private Point _mousePt = new Point(WIDE / 2, HIGH / 2);
    private Rectangle _mouseRect = new Rectangle();
    private Rectangle _mouseBounds = new Rectangle(200,200,300,300);
    private boolean _selecting = false;
    private int _radius = 10;
    private int _radiusPoint = 10;
    private int _thickness = 1;
    private int _radiusCircle = 15;
    private int _radiusLine = 5;
    private List<Figure> _nodes = new ArrayList<>();
    private List<Edge> _edges = new ArrayList<>();
    private List<Background> _Backgrounds = new ArrayList<>();
    private List<Point> _curvePoints = Edge.getcurvePoints();
    private String _name;
}
