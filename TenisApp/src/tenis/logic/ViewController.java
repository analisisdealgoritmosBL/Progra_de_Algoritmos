package tenis.logic;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import tenis.library.Design;
import tenis.library.Program_Mode;


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
    public void updateRadius1() {
        _Administrator.UpdateRadius();
    }
    public void updateThickness(int pThickness) {
        _Administrator.updateThickness(pThickness);
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
        _Administrator.getDesignsFromDatabase();
        return _Administrator.getDesignsName();
    }
    public void saveDesign(String pName) {
        _Administrator.saveDesignName(pName);   
    }
    public void saveDesignToDatabase(){
        _Administrator.saveDesignToDatabase();
    }
    public void getDesign(String pName) {
        _Administrator.getDesing(pName);
    }
    public void setDesign(String pName) {
        _Administrator.setDesing(pName);
    }
    
    public List<Design> _Designs = new ArrayList<>();
    private PaintAdministrator _Administrator;
    private Program_Mode _ModeType = Program_Mode.EDIT;

    

    

    

    

    
    

    
}
