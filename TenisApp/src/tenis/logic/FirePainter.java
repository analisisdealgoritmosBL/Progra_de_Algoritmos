/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import static tenis.logic.FirePainter.getPixelColor;

/**
 *
 * @author Rodrigo
 */
public class FirePainter implements LogicController
{
    @Override
    public void pintar(Design pDesign) {
        System.out.println("Imprimendo en modo Fire");
    }
       
    public static void FirePainter(Graphics g){
        if (pixels.isEmpty()){
            System.out.print("No hay nada que pintar");
        }
        //for (Point e : pixels) {
            g.fillRect(100, 100, 100, 100);
            
        //}
    }
    
    private static void removePoints (){
        for(int i = 0; i<5; i++){
            Figure.updateRadius(_points.get(i), 0);
        }
    }
    
    public static Color getPixelColor(int pX, int pY){
        //removePoints();
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(FirePainter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Color aPixelColor = rb.getPixelColor(pX, pY);//gets the color of the pixel at screen coordinate 0,0.
        return aPixelColor;
    }
    
    public static void polygon(List <Figure> pPoints,List <Edge> pConnections, List <Point> pCurvePoints){
        int [] getXpoints = new int [6];
        int [] getYpoints = new int [6];
        int index = 0;
        for (index = 0; index<5;index++){
            getXpoints[index] = pPoints.get(index).getLocation().x;
            getYpoints[index] = pPoints.get(index).getLocation().y;
        }
        getXpoints[index] = pCurvePoints.get(0).x;
        getYpoints[index] = pCurvePoints.get(0).y;
        getXpoints[index] = pCurvePoints.get(1).x;
        getYpoints[index] = pCurvePoints.get(1).y;
        
        
        shape = new Polygon(getXpoints,getYpoints,7);
        
        List <Point> Con1 = pConnections.get(0).intersect1(pConnections);
        List <Point> Con2 = pConnections.get(0).intersect2(pConnections);
        for (Point connectionX : Con1){
            if(shape.contains(connectionX)){
                _skipPoints.add(connectionX);
            }  
        }
        for (Point connectionY : Con2){
            if(shape.contains(connectionY)){
                _skipPoints.add(connectionY);
            }
        }
    }
    public static void AlgorithmNew(Graphics p){
        removePoints ();
    }
    public static void Algorithm(Graphics p){
        //p.setColor(Color.black);
        //Color black = Color.black;
        //polygon(_points,_Connections,_CurvePoints);
        Color principal =  Color.red;
        p.setColor(principal);
        Point inicio = new Point(_points.get(1).getLocation());
        
        int oldx = inicio.x+15;
        for (int i = 0; i<500; i++){
            p.setColor(principal);
            --inicio.y;
            inicio.x=oldx;
            if (getPixelColor(inicio.x,inicio.y).equals(Color.blue)){
                break;
            }
            else if (getPixelColor(inicio.x,inicio.y).equals(Color.black)){
                principal = Color.green;
            }
                
            for (int j = 0; j<500; j++){
                ++inicio.x;
                if (getPixelColor(inicio.x,inicio.y).equals(Color.blue)){
                    System.out.print("\n");
                    break;
                }
                else if (getPixelColor(inicio.x,inicio.y).equals(Color.black)){
                    p.setColor(Color.orange);
                }
                p.fillRect(inicio.x, inicio.y, 1, 1);
            }
        }        
    }
    
    private static Polygon shape;
    private static List <Figure> _points = PaintAdministrator.getNodes();
    private static List <Edge> _Connections = PaintAdministrator.getEdges();
    private static List <Point> _CurvePoints = PaintAdministrator.getCurvePoints();
    private static List <Point> _skipPoints = new ArrayList();
    private static List <Point> pixels;
}
