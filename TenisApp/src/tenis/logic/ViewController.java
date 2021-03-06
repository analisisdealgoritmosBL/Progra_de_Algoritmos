package tenis.logic;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tenis.library.Design;
import tenis.library.DrawDuration;
import tenis.library.DrawType;
import tenis.library.Program_Mode;
import tenis.views.MainWindow;


public class ViewController {
    
    public ViewController() {
        _Administrator = PaintAdministrator.getInstance();
    }
    
    public void setMode(Program_Mode pMode)
    {
        _ModeType = pMode;
    }
    public Program_Mode getMode()
    {
        return _ModeType;
    }
    
    public void newDesign(String pDesignName)
    {
        //
    }
    public void createDesign() 
    {
        _Administrator.firstDesign();
    }
    public void drawLine() 
    {
        _Administrator.drawLine();
    }
    public void drawCircle() 
    {
        _Administrator.drawCircle();
    }
    public void drawPoint() 
    {
        _Administrator.drawPoint();
    }
    public void updateRadius(int pValue){
        _Administrator.UpdateCircle(pValue);
    }
    public void clean(){
        _Administrator.clear();
    }

    public void paint(Graphics g) throws AWTException {
        _Administrator.paint(g, _ModeType);
    }

    public void mouseDrag(MouseEvent evt) {
        _Administrator.dragNode(evt);
    }

    public void mousePress(MouseEvent evt) {
        _Administrator.Press(evt);
    }
    
    public void mouseReleased(MouseEvent evt) {
        _Administrator.Release(evt);
    }
    
    public void getDesignsFromDatabase() {
        _Administrator.getDesignsFromDatabase();
        _Designs = _Administrator.getDesigns();
    }
    
    public void getBestDrawTimesFromDatabase() {
        _Administrator.getBestDrawTimesFromDatabase();
        _BestDrawTimes = _Administrator.getBestDrawTimes();
    }
    
    public void saveDesignsToDatabase() {
        _Administrator.setDesigns(_Designs);
        _Administrator.saveDesignsToDatabase();
    }
    
    public List<Design> _Designs = new ArrayList<>();
    private Map<String, HashMap<DrawType, DrawDuration>> _BestDrawTimes = new HashMap<String, HashMap<DrawType, DrawDuration>>();
    private PaintAdministrator _Administrator;
    private Program_Mode _ModeType;
    

    public void putColor(MainWindow aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
