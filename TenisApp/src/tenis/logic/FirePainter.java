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
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;
import static tenis.logic.FirePainter.getPixelColor;
import static tenis.logic.FirePainter.polygon;

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
        Figure.updateRadius1(_points, 0);
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
        //getXpoints[index] = pCurvePoints.get(0).x;
        //getYpoints[index] = pCurvePoints.get(0).y;
        //getXpoints[index] = pCurvePoints.get(1).x;
        //getYpoints[index] = pCurvePoints.get(1).y;
        
        
        shape = new Polygon(getXpoints,getYpoints,5);
        
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
    public static void Algorithm(Graphics p){
        //p.setColor(Color.black);
        //Color black = Color.black;
        polygon(_points,_Connections,_CurvePoints);
        Color principal =  Color.red;
        p.setColor(principal);
        removePoints ();
        for (Background pointColor : _Backgrounds){
            FirstRect(p, pointColor);
            SecondRect(p, pointColor);
            ThirdRect(p, pointColor);
            FourthRect(p, pointColor);
        }
    }
    private static void FirstRect(Graphics p,Background pOriginColor){
        int oldPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int oldPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        int actualPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int actualPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        
        Color azul = Color.blue;
        Color negro = Color.black;
        
        p.setColor(pOriginColor.getBackgroundColor());
        
        for (int PixelY = 0; PixelY<500 ;PixelY++){
            actualPointY--;
            actualPointX = oldPointX;
            /*if (FindSpace(actualPointX,actualPointY)&&(getPixelColor(actualPointX,actualPointY).equals(azul)||getPixelColor(actualPointX,actualPointY).equals(negro))){
                oldPointX = PixelPointX;
                System.out.print(actualPointX);
            }*/
            if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                break;
            }
            else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                break;
            }
            
            
            for (int PixelX = 0; PixelX <500; PixelX++){
                actualPointX++;
                System.out.print(actualPointX);
                if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                    break;
                }
                else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                    break;
                }
                p.fillRect(actualPointX, actualPointY, 1, 1);
            }
        }
        
    }
    private static void SecondRect(Graphics p,Background pOriginColor){
        int oldPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int oldPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        int actualPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int actualPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        
        Color azul = Color.blue;
        Color negro = Color.black;
        
        p.setColor(pOriginColor.getBackgroundColor());
        
        for (int PixelY = 0; PixelY<500 ;PixelY++){
            actualPointY++;
            actualPointX = oldPointX;
            if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                break;
            }
            else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                break;
            }
            for (int PixelX = 0; PixelX <500; PixelX++){
                actualPointX++;
                if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                    break;
                }
                else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                    break;
                }
                p.fillRect(actualPointX, actualPointY, 1, 1);
            }
        }
        
    }
    private static void ThirdRect(Graphics p,Background pOriginColor){
        int oldPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int oldPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        int actualPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int actualPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        
        Color azul = Color.blue;
        Color negro = Color.black;
        
        p.setColor(pOriginColor.getBackgroundColor());
        
        for (int PixelY = 0; PixelY<500 ;PixelY++){
            actualPointY++;
            actualPointX = oldPointX;
            if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                break;
            }
            else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                break;
            }
            for (int PixelX = 0; PixelX <500; PixelX++){
                actualPointX--;
                if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                    break;
                }
                else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                    break;
                }
                p.fillRect(actualPointX, actualPointY, 1, 1);
            }
        }
        
    }
    private static void FourthRect(Graphics p,Background pOriginColor){
        int oldPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int oldPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        int actualPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int actualPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        
        Color azul = Color.blue;
        Color negro = Color.black;
        
        p.setColor(pOriginColor.getBackgroundColor());
        
        for (int PixelY = 0; PixelY<500 ;PixelY++){
            actualPointY--;
            actualPointX = oldPointX;
            if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                break;
            }
            else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                break;
            }
            for (int PixelX = 0; PixelX <500; PixelX++){
                actualPointX--;
                if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                    break;
                }
                else if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                    break;
                }
                p.fillRect(actualPointX, actualPointY, 1, 1);
            }
        }        
    }
    
    /*private static boolean FindSpace(int actualPointX, int actualPointY){
        if ((getPixelColor(actualPointX+1,actualPointY+1).equals(Color.blue)||(getPixelColor(actualPointX+1,actualPointY+1).equals(Color.black)))&&
            (getPixelColor(actualPointX+1,actualPointY).equals(Color.blue)||(getPixelColor(actualPointX+1,actualPointY).equals(Color.black)))&&
            (getPixelColor(actualPointX,actualPointY).equals(Color.blue)||(getPixelColor(actualPointX,actualPointY).equals(Color.black)))&&
            (getPixelColor(actualPointX+2,actualPointY).equals(Color.blue)||(getPixelColor(actualPointX+2,actualPointY).equals(Color.black)))){
            return false;
        }
        else{
            for (int PixelX = 0; PixelX <500; PixelX++){
                actualPointX++;
                if (getPixelColor(actualPointX,actualPointY).equals(Color.white)){
                    PixelPointX=actualPointX;
                    System.out.print("\n");
                    return true;
                }
            }
        }
        return false;
    }*/
    
    //private static int PixelPointX;
    //private static int PixelPointX1;
    private static Polygon shape;
    private static List <Figure> _points = PaintAdministrator.getNodes();
    private static List <Edge> _Connections = PaintAdministrator.getEdges();
    private static List <Point> _CurvePoints = PaintAdministrator.getCurvePoints();
    private static List <Background> _Backgrounds = PaintAdministrator.getBackgrounds();
    private static List <Point> _skipPoints = new ArrayList();
    private static List <Point> pixels;
}
