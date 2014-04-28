package tenis.logic;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.List;
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
    public void putColor(Component component) {
        _Administrator.updateColor(component);
    }
    public List<String> loadDesign() {
        return _Administrator.getDesigns();
    }
    
    
    
    private PaintAdministrator _Administrator;
    private Program_Mode _ModeType;

    
    

    
}
