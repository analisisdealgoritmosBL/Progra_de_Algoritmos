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
        _Figure.updateRadius1(pPoints, 0);
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
    }
    
    
    private Figure _Figure = new Figure();
    //private static int PixelPointX1;
}
