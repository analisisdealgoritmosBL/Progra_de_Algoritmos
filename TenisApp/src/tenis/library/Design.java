/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.library;

import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tenis.logic.PaintAdministrator;


public final class Design {
    
    public Design(String pDesignName, Figure pCircle, Edge pLine, Background pBackground, Date pDate, Long pDuration) {
        setName(pDesignName);
        setCircles(pCircle);
        setLines(pLine);
        setBackgrounds(pBackground);
        setDuration(pDate, pDuration);
    }
    
    public String getName() 
    {
        //return PaintAdministrator._name;
        return _DesignName;
    }
    
    public void setName(String pDesignName) {
        _DesignName = pDesignName;
    }
    
    public List<Figure> getCircles() 
    {
        //return PaintAdministrator._nodes;
        return _DesignCircles;
    }
    
    public void setCircles(Figure pDesignCircle) {
            _DesignCircles.add(pDesignCircle);
    }
    
    public List<Edge> getLines()
    {
        //return PaintAdministrator._edges;
        return _DesignLines;
    }
    
    public void setLines(Edge pDesignLine) {
            _DesignLines.add(pDesignLine);
    }
       
    public DateDuration getDuration(){
        return _DateDuration;
    }
    
    public void setDuration(Date pDate, Long pDuration) {
        _DateDuration = new DateDuration(pDate, pDuration);
    }
    
    public void setDuration(DateDuration pDateDuration) {
        _DateDuration = pDateDuration;
    }

    public List<Background> getBackgrounds() {
        return _DesignBackgrounds;
    }

    public void setBackgrounds(Background pDesignBackground) {
            _DesignBackgrounds.add(pDesignBackground);
    }
    
    
    private List<Background> _DesignBackgrounds = new ArrayList<Background>();
    private DateDuration _DateDuration;
    private String _DesignName;
    private List<Figure> _DesignCircles = new ArrayList<Figure>();
    private List<Edge> _DesignLines = new ArrayList<Edge>();
}
