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
    
    //The first two constructors are desirable, though not essential.
    public Design(String pDesignName, Figure pCircle, Edge pLine, Background pBackground, Date pDate, Long pDuration) {
        setName(pDesignName);
        setCircles(pCircle);
        setLines(pLine);
        setBackgrounds(pBackground);
        setDateDuration(pDate, pDuration);
    }
    
    public Design(String pDesignName, Figure pCircle, Edge pLine, Background pBackground, DateDuration pDateDuration) {
        setName(pDesignName);
        setCircles(pCircle);
        setLines(pLine);
        setBackgrounds(pBackground);
        setDateDuration(pDateDuration);
    }
    
    public Design(String pDesignName, List<Figure> pCircles, List<Edge> pLines, List<Background> pBackgrounds, Date pDate, Long pDuration) {
        setName(pDesignName);
        setCircles(pCircles);
        setLines(pLines);
        setBackgrounds(pBackgrounds);
        setDateDuration(pDate, pDuration);
    }
    
    public Design(String pDesignName, List<Figure> pCircles, List<Edge> pLines, List<Background> pBackgrounds, DateDuration pDateDuration) {
        setName(pDesignName);
        setCircles(pCircles);
        setLines(pLines);
        setBackgrounds(pBackgrounds);
        setDateDuration(pDateDuration);
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
    
    public void setCircles(List<Figure> pDesignCircles) {
        for(Figure circle : pDesignCircles)
            _DesignCircles.add(circle);
    }
    
    public List<Edge> getLines()
    {
        //return PaintAdministrator._edges;
        return _DesignLines;
    }
    
    public void setLines(Edge pDesignLine) {
        _DesignLines.add(pDesignLine);
    }
    
    public void setLines(List<Edge> pDesignLines) {
        for(Edge line : pDesignLines)
            _DesignLines.add(line);
    }
    
    public List<Background> getBackgrounds() {
        return _DesignBackgrounds;
    }

    public void setBackgrounds(Background pDesignBackground) {
            _DesignBackgrounds.add(pDesignBackground);
    }
    
    public void setBackgrounds(List<Background> pDesignBackgrounds) {
        for(Background background : pDesignBackgrounds)
            _DesignBackgrounds.add(background);
    }
    
    public DateDuration getDateDuration(){
        return _DateDuration;
    }
    
    public void setDateDuration(Date pDate, Long pDuration) {
        _DateDuration = new DateDuration(pDate, pDuration);
    }
    
    public void setDateDuration(DateDuration pDateDuration) {
        _DateDuration = pDateDuration;
    }
    
    private List<Background> _DesignBackgrounds = new ArrayList<>();
    private DateDuration _DateDuration;
    private String _DesignName;
    private List<Figure> _DesignCircles = new ArrayList<>();
    private List<Edge> _DesignLines = new ArrayList<>();
}
