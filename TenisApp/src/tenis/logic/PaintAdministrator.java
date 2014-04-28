package tenis.logic;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.DrawDuration;
import tenis.library.DrawType;
import tenis.library.Edge;
import tenis.library.Figure;
import tenis.library.Program_Mode;

public class PaintAdministrator 
{

    public void paint(Graphics p, Program_Mode pMode) throws AWTException{
        
        switch(pMode){
                case EDIT: 
                    _Editor.paint(p, _nodes, _edges, _mouseRect, _selecting); 
                    break;
                case FIRE:
                    _Editor.paint(p, _nodes, _edges, _mouseRect, _selecting);
                    _Fire.Algorithm(p, _nodes, _Backgrounds);
                    break;
                case ARCADE:
                    _Editor.paint(p, _nodes, _edges, _mouseRect, _selecting);
                    _Arcade.Algorithm(p,_nodes, _Backgrounds);
                    break;
                default:
                    _Editor.paint(p, _nodes, _edges, _mouseRect, _selecting); 
                    break;
                
        }    
    }

    public void dragNode(MouseEvent evt) {
        Point delta = new Point();
        //if (!_Editor.RectIntersect(PaintAdministrator.getListFigure())){
            
        //}
        if (_selecting) {

        //if (_Editor.colitions(PaintAdministrator.getListFigure(), PaintAdministrator._edges)){
            _mouseRect.setBounds(
                Math.min(_mousePt.x, evt.getX()),
                Math.min(_mousePt.y, evt.getY()),
                Math.abs(_mousePt.x - evt.getX()),
                Math.abs(_mousePt.y - evt.getY()));
            _Editor.selectRect(_nodes, _mouseRect);
        //}
        }
        
        
        else {
            delta.setLocation(
                evt.getX() - _mousePt.x,
                evt.getY() - _mousePt.y);
            
                _Editor.updatePosition(_nodes, delta);
            
            _mousePt = evt.getPoint();
        }
    }

    public void Press(MouseEvent evt) {
        _mousePt = evt.getPoint();
        if (evt.isShiftDown()) {
            _Editor.selectToggle(_nodes, _mousePt);
        } else if (evt.isPopupTrigger()) {
            _Editor.selectOne(_nodes, _mousePt);
            //showPopup(evt);
        } else if (_Editor.selectOne(_nodes, _mousePt)) {
            _selecting =false;
        } else {
            _Editor.selectNone(_nodes);
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
    
    
    public void loadDesign(Design pDesign) 
    {
        LogicController painter = _Painters.get(_ModeType);
        painter.pintar(pDesign);
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
    
    void updateColor(Component component) {
        _Editor.putColor(component, _nodes);
    }
    
    void updateThickness(int pThickness) {
        _Editor.putThickness(pThickness, _edges);
    }
    
    public List<String> getDesigns() {
        List<String> names = new ArrayList();
        for (Design design : _Designs){
            names.add(design.getName());
        }
        return names;
    }

    public Map<String, HashMap<DrawType, DrawDuration>> getBestDrawTimes() {
        return _BestDrawTimes;
    }
    
    public void getBestDrawTimesFromDatabase() {
        _DBController.getBestDrawTimesFromDatabase();
        _BestDrawTimes = _DBController.getFetchedBestDrawTimes();
                
    }
    
    public void getDesignsFromDatabase() {
        _DBController.getDesignsFromDatabase();
        _Designs = _DBController.getFetchedDesignList();
    }
    
    public void saveDesignsToDatabase() {
        _DBController.setSavedDesignList(_Designs);
        _DBController.saveDesignsToDatabase();
    }
    
    
    private Map<String, HashMap<DrawType, DrawDuration>> _BestDrawTimes = new HashMap<String, HashMap<DrawType, DrawDuration>>();
    private List<Design> _Designs = new ArrayList<>();
    private Program_Mode _ModeType;
    private static PaintAdministrator _PainterLogic;
    private DatabaseController _DBController = new DatabaseController();
    private Dictionary<Program_Mode, LogicController> _Painters;
    private EditorPainter _Editor = new EditorPainter();    
    private FirePainter _Fire = new FirePainter();
    private ArcadePainter _Arcade = new ArcadePainter();
    private final int WIDE = 640;
    private final int HIGH = 480;
    private Point _mousePt = new Point(WIDE / 2, HIGH / 2);
    private Rectangle _mouseRect = new Rectangle();
    private boolean _selecting = false;
    private int _radius = 10;
    private int _radiusPoint = 10;
    private int _thickness = 1;
    private int _radiusCircle = 15;
    private int _radiusLine = 5;
    private List<Figure> _nodes = new ArrayList<>();
    private List<Edge> _edges = new ArrayList<>();
    private List<Background> _Backgrounds = new ArrayList<>();
    private List<Point> _curvePoints;
    private List<Design> _Designs;

    
}
