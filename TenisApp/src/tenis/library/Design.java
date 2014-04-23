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
        //return _DesignName;
    }
    
    public void setName(String pDesignName) {
        _DesignName = pDesignName;
    }
    
    public List<Figure> getCircles() 
    {
        return PaintAdministrator._nodes;
        //return _DesignCircles;
    }
    
    public void setCircles(List<Figure> pDesignCircles) {
        for(Figure designCircle : pDesignCircles)
            _DesignCircles.add(designCircle);
    }
    
    public List<Edge> getLines()
    {
        return PaintAdministrator._edges;
        //return _DesignLines;
    }
    
    public void setLines(List<Edge> pDesignLines) {
        for(Edge designLine : pDesignLines)
            _DesignLines.add(designLine);
    }
    
       
    public Long getDuration(){
        return _Duration;
    }
    
    public void setDuration(Long pDuration) {
        _Duration = pDuration;
    }

    public List<Background> getDesignBackgrounds() {
        return _DesignBackgrounds;
    }

    public void setDesignBackgrounds(List<Background> pDesignBackgrounds) {
        for(Background designBackground : pDesignBackgrounds)
            _DesignBackgrounds.add(designBackground);
    }
    
    
    private List<Background> _DesignBackgrounds;
    private Long _Duration;
    private String _DesignName;
    private List<Figure> _DesignCircles;
    private List<Edge> _DesignLines;
}
