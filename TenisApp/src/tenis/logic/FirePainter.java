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
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.Edge;
import tenis.library.Figure;

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
    
    private void removePoints (List <Figure> pPoints){
        Figure.updateRadius1(pPoints, 0);
    }
    
    public void polygon(List <Figure> pPoints,List <Edge> pConnections, List <Point> pCurvePoints){
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
        
        
        Polygon shape = new Polygon(getXpoints,getYpoints,5);
        
        List <Point> Con1 = pConnections.get(0).intersect1(pConnections);
        List <Point> Con2 = pConnections.get(0).intersect2(pConnections);
        for (Point connectionX : Con1){
            if(shape.contains(connectionX)){
                //_skipPoints.add(connectionX);
            }  
        }
        for (Point connectionY : Con2){
            if(shape.contains(connectionY)){
                //_skipPoints.add(connectionY);
            }
        }
    }
    
    public Color getPixelColor(int pX, int pY){
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
    
    public void Algorithm(Graphics p,List <Figure> pPoints,List <Background> pBackgrounds) throws AWTException{
        //p.setColor(Color.black);
        //Color black = Color.black;
        removePoints (pPoints);
        for (Background pointColor : pBackgrounds){
            floodFillScanlineStack(p, pointColor.getBackgroundFigure1().getLocation().x, pointColor.getBackgroundFigure1().getLocation().y, Color.white, pointColor.getBackgroundColor());
        }
    }
    
    void floodFillScanlineStack(Graphics p,int x, int y,  Color targetColor, Color replacementColor) throws AWTException
    {
        Robot robot = new Robot();
        if(targetColor == replacementColor) return;
        Stack pending = new Stack();
        boolean spanLeft, spanRight;

        //if (pending.isEmpty())return;
        
        pending.push(new Point(x,y));
        
        while(!pending.isEmpty()){
            Point g = (Point)pending.pop();
            spanLeft = spanRight = false;
            while(robot.getPixelColor(g.x, g.y).equals(targetColor))
            {
                p.setColor(replacementColor);
                p.fillRect(g.x, g.y, 1, 1);
                if(!spanLeft && robot.getPixelColor(g.x-1, g.y).equals(targetColor)) 
                {
                    pending.push(new Point(g.x-1, g.y));
                    spanLeft = true;
                }
                else if(spanLeft && !robot.getPixelColor(g.x-1, g.y).equals(targetColor))
                {
                    spanLeft = false;
                }
                if(!spanRight && robot.getPixelColor(g.x+1, g.y).equals(targetColor)) 
                {
                    pending.push(new Point(g.x+1, g.y));
                    spanRight = true;
                }
                else if(spanRight && !robot.getPixelColor(g.x+1, g.y).equals(targetColor))
                {
                    spanRight = false;
                } 
                pending.push(new Point(g.x, g.y+1));
                pending.push(new Point(g.x, g.y-1));
            }
            
        }
        System.out.print("sali");
    }
    
    /*private void FirstRect(Graphics p,Background pOriginColor){
        int oldPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int oldPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        int actualPointX = pOriginColor.getBackgroundFigure1().getLocation().x;
        int actualPointY = pOriginColor.getBackgroundFigure1().getLocation().y;
        
        Color azul = Color.blue;
        Color negro = Color.black;
        
        p.setColor(pOriginColor.getBackgroundColor());
        
        for (int PixelY = 0; PixelY<500 ;PixelY++){
            actualPointY--;
            if (FindSpace(actualPointX,actualPointY)&&(getPixelColor(actualPointX,actualPointY).equals(negro)||getPixelColor(actualPointX,actualPointY).equals(azul))){
                oldPointX = PixelPointX;
            }
            if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                break;
            }
            else if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                break;
            }
            actualPointX = oldPointX;
            for (int PixelX = 0; PixelX <500; PixelX++){
                actualPointX++;
                System.out.print(actualPointX);
                if (getPixelColor(actualPointX,actualPointY).equals(negro)){
                    break;
                }
                else if (getPixelColor(actualPointX,actualPointY).equals(azul)){
                    break;
                }
                p.fillRect(actualPointX, actualPointY, 1, 1);
            }
        }
        
    }
    private void SecondRect(Graphics p,Background pOriginColor){
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
    private void ThirdRect(Graphics p,Background pOriginColor){
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
    private void FourthRect(Graphics p,Background pOriginColor){
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
    
    private boolean FindSpace(int actualPointX, int actualPointY){
        for (int PixelX = 0; PixelX <500; PixelX++){
            actualPointX++;
            if (getPixelColor(actualPointX,actualPointY).equals(Color.white)){
                PixelPointX=actualPointX;
                return true;
            }
        }
        
        return false;
    }*/
    
    private int PixelPointX;
    //private static int PixelPointX1;
}
