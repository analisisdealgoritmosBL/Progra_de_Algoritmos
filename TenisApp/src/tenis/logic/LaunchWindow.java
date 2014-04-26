/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import tenis.library.Program_Mode;
import tenis.views.MainWindow;


public class LaunchWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        _window.show();
    }
    
    public void setMode(Program_Mode pMode)
    {
        _ModeType = pMode;
    }
    public Program_Mode getMode()
    {
        return _ModeType;
    }
    
    public void nameDesign(String pDesignName)
    {
        _Administrator.nameDesign(pDesignName);
    }
    public void createDesign() 
    {
        _window.;
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
    public void UpdateRadius(int pValue){
        _Administrator.UpdateCircle(pValue);
    }
    public void Clean(){
        _Administrator.clear();
    }

    public void paint(Graphics g) {
        _window.paint(g);
        _Administrator.paint(g, _ModeType);
    }

    public void Drag(MouseEvent evt) {
        _Administrator.dragNode(evt);
    }

    public void MousePress(MouseEvent evt) {
        _Administrator.Press(evt);
    }
    
    public void Released(MouseEvent evt) {
        _Administrator.Release(evt);
    }
    
    
    private static MainWindow _window = new MainWindow();
    private PaintAdministrator _Administrator = PaintAdministrator.getInstance();
    private String _desing;
    private Program_Mode _ModeType;
    
}
