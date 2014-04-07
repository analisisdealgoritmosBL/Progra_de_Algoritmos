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
    public void getTool(int _option){
            
    }
    public void Point (Graphics g){
        g.setColor (Color.blue);
        g.drawLine (0, 70, 100, 70);
        g.drawRect (150, 70, 50, 70);
    }
    
}
