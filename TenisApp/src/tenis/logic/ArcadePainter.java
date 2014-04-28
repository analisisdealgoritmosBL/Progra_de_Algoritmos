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
import java.awt.Robot;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Background;
import tenis.library.Design;
import tenis.library.Figure;

/**
 *
 * @author Rodrigo
 */
public class ArcadePainter implements LogicController {

    @Override
    public void pintar(Design pDesign) {
        System.out.println("Imprimendo en modo Arcade");
        //pDesign.getFiguras();
        //Debe realizarse para todas las Figuras en Design
        //boundaryFloodFill(pDesign.getFiguras().getX(), pDesign.getFiguras().getY());
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
            floodFill1(p, pointColor.getBackgroundFigure1().getLocation().x, pointColor.getBackgroundFigure1().getLocation().y, Color.white, pointColor.getBackgroundColor());
        }
    }
    
    public void floodFillRecursive(Graphics g, int x, int y, Color targetColor, Color replacementColor) throws AWTException{

        Robot robot = new Robot();


        if(robot.getPixelColor(x, y).equals(Color.red)){
            return;
        }

        g.setColor(replacementColor);
        g.fillRect(x, y, 1, 1);

        if(robot.getPixelColor(x-1, y).equals(targetColor)){
            floodFillRecursive(g, x-1, y, targetColor, replacementColor);
        }

        if(robot.getPixelColor(x+1, y).equals(targetColor)){
            floodFillRecursive(g, x+1, y, targetColor, replacementColor);
        }

        if(robot.getPixelColor(x, y-1).equals(targetColor)){
            floodFillRecursive(g, x, y-1, targetColor, replacementColor);
        }

        if(robot.getPixelColor(x, y+1).equals(targetColor)){
            floodFillRecursive(g, x, y+1, targetColor, replacementColor);
        }
    }
    private void floodFill1(Graphics g, int x, int y, Color targetColor, Color replacementColor) throws AWTException {
        Robot robot = new Robot();
        Stack pending = new Stack();
        pending.push(new Point(x, y));
        while (!pending.empty()) {
            Point p = (Point)pending.pop();
            if (robot.getPixelColor(p.x, p.y).equals(targetColor)) {
                g.setColor(replacementColor);
                g.fillRect(p.x, p.y, 1, 1);
                pending.push(new Point(p.x - 1, p.y));
                pending.push(new Point(p.x + 1, p.y));
                pending.push(new Point(p.x, p.y - 1));
                pending.push(new Point(p.x, p.y + 1));
            }
        }
    }
    private Figure _Figure = new Figure();
}
