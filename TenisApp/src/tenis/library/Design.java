package tenis.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Saves information about the design characteristics: name,
 * list of figures, list of edges, dateduration for arcade and
 * fire algorithms.
 * @author L. Antonio Hidalgo
 */
public final class Design {
    
    //The first two constructors are desirable, though not essential.
    public Design(String pDesignName, Figure pCircle, Edge pLine, 
            Background pBackground, Date pDateFire, Long pDurationFire, Date pDateArcade, Long pDurationArcade) {
        setName(pDesignName);
        setCircles(pCircle);
        setLines(pLine);
        setBackgrounds(pBackground);
        _FireDuration = new DrawDuration(new DateDuration(pDateFire, pDurationFire), DrawType.Fire);
        _ArcadeDuration = new DrawDuration(new DateDuration(pDateArcade, pDurationArcade), DrawType.Arcade);
    }
    
    public Design(String pDesignName, Figure pCircle, Edge pLine, Background pBackground, 
            DateDuration pDateDurationFire, DateDuration pDateDurationArcade) {
        setName(pDesignName);
        setCircles(pCircle);
        setLines(pLine);
        setBackgrounds(pBackground);
        _FireDuration = new DrawDuration(pDateDurationFire, DrawType.Fire);
        _ArcadeDuration = new DrawDuration(pDateDurationArcade, DrawType.Arcade);
    }
    
    public Design(String pDesignName, Figure pCircle, Edge pLine,
            Background pBackground, DrawDuration pDrawDurationFire, DrawDuration pDrawDurationArcade) {
        setName(pDesignName);
        setCircles(pCircle);
        setLines(pLine);
        setBackgrounds(pBackground);
        _FireDuration = pDrawDurationFire;
        _ArcadeDuration = pDrawDurationArcade;
    }
    
    public Design(String pDesignName, List<Figure> pCircles, List<Edge> pLines, 
            List<Background> pBackgrounds, Date pDateFire, Long pDurationFire, Date pDateArcade, Long pDurationArcade) {
        setName(pDesignName);
        setCircles(pCircles);
        setLines(pLines);
        setBackgrounds(pBackgrounds);
        _FireDuration = new DrawDuration(new DateDuration(pDateFire, pDurationFire), DrawType.Fire);
        _ArcadeDuration = new DrawDuration(new DateDuration(pDateArcade, pDurationArcade), DrawType.Arcade);
    }
    
    public Design(String pDesignName, List<Figure> pCircles, List<Edge> pLines, 
            List<Background> pBackgrounds, DateDuration pDateDurationFire, DateDuration pDateDurationArcade) {
        setName(pDesignName);
        setCircles(pCircles);
        setLines(pLines);
        setBackgrounds(pBackgrounds);
        _FireDuration = new DrawDuration(pDateDurationFire, DrawType.Fire);
        _ArcadeDuration = new DrawDuration(pDateDurationArcade, DrawType.Arcade);
    }
    
    public Design(String pDesignName, List<Figure> pCircles, List<Edge> pLines, 
            List<Background> pBackgrounds, DrawDuration pDrawDurationFire, DrawDuration pDrawDurationArcade) {
        setName(pDesignName);
        setCircles(pCircles);
        setLines(pLines);
        setBackgrounds(pBackgrounds);
        _FireDuration = pDrawDurationFire;
        _ArcadeDuration = pDrawDurationArcade;
    }
    
    public Design(String pDesignName, List<Figure> pCircles, List<Edge> pLines, 
            List<Background> pBackgrounds) {
        setName(pDesignName);
        setCircles(pCircles);
        setLines(pLines);
        setBackgrounds(pBackgrounds);
        _FireDuration = new DrawDuration(new DateDuration (new Date(), 5*60*1000L), DrawType.Fire);
        _ArcadeDuration = new DrawDuration(new DateDuration (new Date(), 5*60*1000L), DrawType.Arcade);
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
    
    public DrawDuration getFireDuration(){
        return _FireDuration;
    }
    
    public void setFireDuration(DateDuration pDuration) {
        _FireDuration.setDateDuration(pDuration);
    }
    
    public void setFireDuration(Date pDateFire, Long pDurationFire) {
        _FireDuration.setDateDuration(new DateDuration(pDateFire, pDurationFire));
    }
    
    public DrawDuration getArcadeDuration(){
        return _ArcadeDuration;
    }
    
    public void setArcadeDuration(DateDuration pDuration) {
        _ArcadeDuration.setDateDuration(pDuration);
    }
    
    public void setArcadeDuration(Date pDateArcade, Long pDurationArcade) {
        _FireDuration.setDateDuration(new DateDuration(pDateArcade, pDurationArcade));
    }
    
    
    private List<Background> _DesignBackgrounds = new ArrayList<>();
    private DrawDuration _FireDuration;
    private DrawDuration _ArcadeDuration;
    private String _DesignName;
    private List<Figure> _DesignCircles = new ArrayList<>();
    private List<Edge> _DesignLines = new ArrayList<>();
}
