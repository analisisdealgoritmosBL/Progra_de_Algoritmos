/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.app;

import tenis.library.Program_Mode;
import tenis.logic.PaintAdministrator;
import tenis.views.MainWindow;


public class Main {

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
    
    public static void nameDesign(String pDesignName)
    {
        PaintAdministrator.nameDesign(pDesignName);
    }
    public static void createDesign() 
    {
        PaintAdministrator.firstDesign();
    }
    public static void drawLine() 
    {
        PaintAdministrator.drawLine();
    }
    public static void drawCircle() 
    {
        PaintAdministrator.drawCircle();
    }
    public static void drawPoint() 
    {
        PaintAdministrator.drawPoint();
    }
    public static void UpdateRadius(int pValue){
        PaintAdministrator.UpdateCircle(pValue);
    }
    public static void Clean(){
        PaintAdministrator.clear();
    }
    
    private String _desing;
    private static Program_Mode _ModeType;

    
    
}
