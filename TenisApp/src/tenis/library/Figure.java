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
    
    public void Point (Graphics pfigure, int pcoordxPoint, int pcoordyPoint, int pwidthPoint, int pheightPoint){
        pfigure.setColor (Color.blue);
        pfigure.fillOval(pcoordxPoint, pcoordyPoint, pwidthPoint, pheightPoint);
    }
    
    public void Circle (Graphics pfigure, int pcoordxCircle, int pcoordyCircle, int pwidthCircle, int pheightCircle){
        pfigure.setColor (Color.blue);
        pfigure.drawOval(pcoordxCircle, pcoordyCircle, pwidthCircle, pheightCircle);
    }
    
    public void Line (Graphics pfigure, int pcoordxLine, int pcoordyLine, int pwidthLine, int pheightLine){
        pfigure.setColor (Color.blue);
        pfigure.drawLine(pcoordxLine, pcoordyLine, pwidthLine, pheightLine);
    }
    
    public void Sole (Graphics pfigure, int pcoordxSole, int pcoordySole, int pwidthSole, int pheightSole){
        pfigure.setColor (Color.blue);
        pfigure.drawLine(pcoordxSole, pcoordySole, pwidthSole, pheightSole);
    }
}
