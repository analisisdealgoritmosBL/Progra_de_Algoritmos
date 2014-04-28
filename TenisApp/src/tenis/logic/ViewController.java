package tenis.logic;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
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

    public void paint(Graphics g) {
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
    
    public List<Design>
    
    private PaintAdministrator _Administrator;
    private Program_Mode _ModeType;
    

    public void putColor(MainWindow aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
