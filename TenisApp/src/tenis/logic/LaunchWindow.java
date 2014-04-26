/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import tenis.library.Program_Mode;
import tenis.logic.PaintAdministrator;
import tenis.views.MainWindow;


public class LaunchWindow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainWindow _window = new MainWindow();
        _window.show();
    }
    
    public static void setMode(Program_Mode pMode)
    {
        _ModeType = pMode;
    }
    public static Program_Mode getMode()
    {
        return _ModeType;
    }
    
    public void nameDesign(String pDesignName)
    {
        _Administrator.nameDesign(pDesignName);
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
    public void UpdateRadius(int pValue){
        _Administrator.UpdateCircle(pValue);
    }
    public void Clean(){
        _Administrator.clear();
    }

    public void paint(Graphics g) {
        _Administrator.paint(g);
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
    
    private PaintAdministrator _Administrator = PaintAdministrator.getInstance();
    private String _desing;
    private static Program_Mode _ModeType;
    
}
