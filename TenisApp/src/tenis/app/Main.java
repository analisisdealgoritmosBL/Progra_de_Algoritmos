/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.app;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import tenis.library.Figure;
import tenis.library.Figure_Kind;
import tenis.library.Proram_Mode;
import tenis.logic.PaintAdministrator;
import tenis.views.MainWindow;

/**
 *
 * @author Rodrigo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainWindow _window = new MainWindow();
        _window.show();
    }
    
    public void setMode(Proram_Mode pMode)
    {
        _ModeType = pMode;
    }
    public void newDesign(String pdesignName)
    {
        PaintAdministrator.newDesign();
    }
    public static void createDesingPoints(Point mousePt, Figure_Kind kind, int radius, List<Figure> nodes) {
        PaintAdministrator.firsthDesignPoints(mousePt, kind,radius, nodes);
    }
    public static void createDesingLines(int x1, int x2, int x3, int x4, Figure_Kind kind, List<Figure> nodes) {
        PaintAdministrator.firsthDesignLines(x1, x2, x3, x4, kind, nodes);
    }
    public static void createDesingCurves(Point point1,Point curve,Point point2, Figure_Kind kind, List<Figure> nodes) {
        PaintAdministrator.firsthDesignCurves(point1,curve,point2,kind, nodes);
    }
    
    private String _desing;
    private Proram_Mode _ModeType;

    
    
}
