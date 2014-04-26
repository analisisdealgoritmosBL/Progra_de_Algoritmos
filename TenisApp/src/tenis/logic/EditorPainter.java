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
        for (Edge e :PaintAdministrator.getEdges()) {
            e.draw(g2);
        }
        for (Figure n : PaintAdministrator.getNodes()){
            n.draw(g2);
        }
        if (PaintAdministrator.isSelecting()) {
            g.setColor(Color.darkGray);
            g.drawRect(PaintAdministrator.getMouseRect().x, PaintAdministrator.getMouseRect().y,
                PaintAdministrator.getMouseRect().width, PaintAdministrator.getMouseRect().height);
        }
        
    }
    
    public static void nameDesign(String pName){
        PaintAdministrator.setName(pName);
    }
    
    public static void firstDesign() 
    {
        Point point1 = new Point(212,128);
        Point point2 = new Point(212,323);
        Point point3 = new Point(448,128);
        Point point4 = new Point(581,218);
        Point point5 = new Point(680,323);
        Point curve1 = new Point(150,175);
        Point curve2 = new Point(330,170);
        Figure.firsthDesignPoints(point1,Figure_Kind.Point,PaintAdministrator.getRadius(),PaintAdministrator.getNodes());
        Figure.firsthDesignPoints(point2,Figure_Kind.Point,PaintAdministrator.getRadius(),PaintAdministrator.getNodes());
        Figure.firsthDesignPoints(point3,Figure_Kind.Point,PaintAdministrator.getRadius(),PaintAdministrator.getNodes());
        Figure.firsthDesignPoints(point4,Figure_Kind.Point,PaintAdministrator.getRadius(),PaintAdministrator.getNodes());
        Figure.firsthDesignPoints(point5,Figure_Kind.Point,PaintAdministrator.getRadius(),PaintAdministrator.getNodes());
        
        Figure n0 = PaintAdministrator.getNodes().get(0);
        Figure n1 = PaintAdministrator.getNodes().get(1);
        Figure n2 = PaintAdministrator.getNodes().get(2);
        Figure n3 = PaintAdministrator.getNodes().get(3);
        Figure n4 = PaintAdministrator.getNodes().get(4);
        PaintAdministrator.getEdges().add(new Edge(n2, n3,Figure_Kind.Line,0, PaintAdministrator.getThickness(), Color.blue));
        PaintAdministrator.getEdges().add(new Edge(n3, n4,Figure_Kind.Line,0, PaintAdministrator.getThickness(), Color.blue));
        PaintAdministrator.getEdges().add(new Edge(n1, n4,Figure_Kind.Line,0, PaintAdministrator.getThickness(), Color.blue));
        PaintAdministrator.getEdges().add(new Edge(n0, n1,Figure_Kind.Curve,1, PaintAdministrator.getThickness(), Color.blue));
        PaintAdministrator.getEdges().add(new Edge(n0, n2,Figure_Kind.Curve,2, PaintAdministrator.getThickness(), Color.blue));
    }
    
    public static void putColor(Component component){
        Color color = null;
        color = JColorChooser.showDialog(component, "Choose a color", color);
        if (color != null) {
            Figure.updateColor(PaintAdministrator.getNodes(), color);
            
        }
    }
    
    public static void drawLine() 
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Point point1 = new Point ((WIDE/2)+50, (HIGH/2)+50);
        Figure.lines(point, point1, PaintAdministrator.getRadiusLine(), Figure_Kind.Point,Figure_Kind.Line,PaintAdministrator.getNodes(),PaintAdministrator.getEdges());
    }
    
    public static void drawCircle()
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Figure.circle(point, PaintAdministrator.getRadiusCircle(), PaintAdministrator.getThickness(), Figure_Kind.Circle,PaintAdministrator.getNodes());
    }
    
    
    public static void drawPoint()
    {
        Point point = new Point (WIDE/2, HIGH/2);
        Figure.firsthDesignPoints(point,Figure_Kind.Point,PaintAdministrator.getRadiusPoint(),PaintAdministrator.getNodes());
    }
    
    public static void UpdateRadius(int pValue){
        
        Figure.updateRadius(PaintAdministrator.getNodes(), pValue);
    }
    private static final int WIDE = 640;
    private static final int HIGH = 480;
    
    
    
}

