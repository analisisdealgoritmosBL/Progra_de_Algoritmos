package tenis.logic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JColorChooser;
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import tenis.library.FigureType;

/**
 *
 * @author Rodrigo
 */
public class EditorPainter implements LogicController
{
    
    
    @Override
    public void pintar(Design pDesign) {
        System.out.println("Modo de Edición");
    }
    
    public void paint (Graphics g,  List<Figure> pNodes, List<Edge> pEdges, Rectangle pMouseRect, boolean Selecting){
        Graphics2D g2 = (Graphics2D) g;
        
        //new Color(0x00f0f0f0)
        for (Edge e : pEdges) {
            e.draw(g2);
        }
        for (Figure n : pNodes){
            n.draw(g2);
        }
        if (Selecting) {
            g.setColor(Color.darkGray);
            g.drawRect(pMouseRect.x, pMouseRect.y,pMouseRect.width,pMouseRect.height);
        }
        
    }
    
    /*public void nameDesign(String pName){
        PaintAdministrator.setName(pName);
    }*/
    
    public void firstDesign(List<Figure> pNodes, List<Edge> pEdges, int pRadius, int pThickness) 
    {
        Point point1 = new Point(212,128);
        Point point2 = new Point(212,323);
        Point point3 = new Point(448,128);
        Point point4 = new Point(581,218);
        Point point5 = new Point(680,323);
        Point curve1 = new Point(150,175);
        Point curve2 = new Point(330,170);
        _Figure.firstDesignPoints(point1,FigureType.Point,pRadius,pNodes);
        _Figure.firstDesignPoints(point2,FigureType.Point,pRadius,pNodes);
        _Figure.firstDesignPoints(point3,FigureType.Point,pRadius,pNodes);
        _Figure.firstDesignPoints(point4,FigureType.Point,pRadius,pNodes);
        _Figure.firstDesignPoints(point5,FigureType.Point,pRadius,pNodes);
        
        Figure n0 = pNodes.get(0);
        Figure n1 = pNodes.get(1);
        Figure n2 = pNodes.get(2);
        Figure n3 = pNodes.get(3);
        Figure n4 = pNodes.get(4);
        pEdges.add(new Edge(n2, n3,FigureType.Line,0, pThickness, Color.blue));
        pEdges.add(new Edge(n3, n4,FigureType.Line,0, pThickness, Color.blue));
        pEdges.add(new Edge(n1, n4,FigureType.Line,0, pThickness, Color.blue));
        pEdges.add(new Edge(n0, n1,FigureType.Curve,1, pThickness, Color.blue));
        pEdges.add(new Edge(n0, n2,FigureType.Curve,2, pThickness, Color.blue));
    }
    
    public void putColor(Component component, List<Figure> pNodes){
        Color color = null;
        color = JColorChooser.showDialog(component, "Choose a color", color);
        if (color != null) {
            _Figure.updateColor(pNodes, color);
        }
    }
    
    public void drawLine(int pRadiusLine, List<Figure> pNodes, List<Edge> pEdges ) 
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Point point1 = new Point ((WIDE/2)+50, (HIGH/2)+50);
        _Figure.lines(point, point1, pRadiusLine, FigureType.Point,FigureType.Line,pNodes,pEdges);
    }
    
    public void drawCircle(int pRadiusCircle, List<Figure> pNodes, int pThickness)
    {
        Point point = new Point (WIDE/2, HIGH/2);
        _Figure.circle(point, pRadiusCircle, pThickness, FigureType.Circle,pNodes);
    }
    
    
    public void drawPoint(int pRadiusPoint, List<Figure> pNodes, List<Background> pBackground)
    {
        Point point = new Point (WIDE/2, HIGH/2);
        _Figure.Points(point,FigureType.Point,pRadiusPoint,pNodes,pBackground);
    }
    
    public void UpdateRadius(int pValue, List<Figure> pNodes){
        
        _Figure.updateRadius(pNodes, pValue);
        
    }
    
    public void putThickness(int pThickness, List<Edge> _edges) {
        _Edges.updateThickness(_edges, pThickness);
    }
    
    public void selectRect(List<Figure> _nodes, Rectangle _mouseRect) {
        _Figure.selectRect(_nodes, _mouseRect);
    }

    public void updatePosition(List<Figure> _nodes, Point delta) {
        _Figure.updatePosition(_nodes, delta);
    }

    public void selectToggle(List<Figure> _nodes, Point _mousePt) {
        _Figure.selectToggle(_nodes, _mousePt);
    }

    public boolean selectOne(List<Figure> _nodes, Point _mousePt) {
        return _Figure.selectOne(_nodes, _mousePt);
    }

    public void selectNone(List<Figure> _nodes) {
        _Figure.selectNone(_nodes);
    }
    
    private Figure _Figure = new Figure();
    private Edge _Edges = new Edge();
    
    private int WIDE = 640;
    private int HIGH = 480;

    

    
    
    
    
}

