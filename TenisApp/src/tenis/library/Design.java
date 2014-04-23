/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.library;

import java.awt.Color;
import java.sql.Time;
import java.util.List;
import tenis.logic.PaintAdministrator;


public class Design {
    
    public String getName() 
    {
        return PaintAdministrator._name;
    }
    
    public List<Figure> getDotsAndCircles() 
    {
        return PaintAdministrator._nodes;
    }
    
    public List<Edge> getLines()
    {
        return PaintAdministrator._edges;
    }
    public Color getColors() 
    {
        return _Colors;
    }
    public Time getTime(){
        return _time;
    }
    private Time _time;
    private Color _Colors;
    
}
