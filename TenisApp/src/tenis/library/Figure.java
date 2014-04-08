/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenis.library;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Braulio Rivera
 */
public class Figure {
    
    public void Point (Graphics pFigure, int pCoordXPoint, int pCoordYPoint, int pWidthPoint, int pHeightPoint){
        pFigure.setColor (Color.blue);
        pFigure.fillOval(pCoordXPoint, pCoordYPoint, pWidthPoint, pHeightPoint);
    }
    
    public void Circle (Graphics pFigure, int pCoordXCircle, int pCoordYCircle, int pWidthCircle, int pHeightCircle){
        pFigure.setColor (Color.blue);
        pFigure.drawOval(pCoordXCircle, pCoordYCircle, pWidthCircle, pHeightCircle);
    }
    
    public void Line (Graphics pFigure, int pCoordXLine, int pCoordYLine, int pWidthLine, int pHeightLine){
        pFigure.setColor (Color.blue);
        pFigure.drawLine(pCoordXLine, pCoordYLine, pWidthLine, pHeightLine);
    }
    
    public void Sole (Graphics pFigure, int pCoordXSole, int pCoordYSole, int pWidthSole, int pHeightSole){
        pFigure.setColor (Color.blue);
        pFigure.drawLine(pCoordXSole, pCoordYSole, pWidthSole, pHeightSole);
    }
}
