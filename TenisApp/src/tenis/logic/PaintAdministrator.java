/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.util.Dictionary;
import java.util.Hashtable;
import tenis.library.Design;
import tenis.library.Proram_Mode;

/**
 *
 * @author Rodrigo
 */
public class PaintAdministrator 
{
    

    private PaintAdministrator() 
    {
        _Painters = new Hashtable<Proram_Mode, LogicController>();
        _Painters.put(Proram_Mode.EDIT, new EditorPainter());
        _Painters.put(Proram_Mode.ARCADE, new ArcadePainter());
        _Painters.put(Proram_Mode.FIRE, new FirePainter());
    }
    
    public synchronized static PaintAdministrator getInstance() 
    {
        if (_PainterLogic==null)
        {
            _PainterLogic = new PaintAdministrator();
        }
        return _PainterLogic;
    }
    
    
    public void cargarDiseno(Design pDesino) 
    {
        LogicController painter = _Painters.get(_ModeType);
        painter.pintar(pDesino);
    }
    
    public void setMode(Proram_Mode pMode)
    {
        _ModeType = pMode;
    }
    
    public static void nameDesign(String pName) 
    {
        EditorPainter.nameDesign(pName);
    }
    
    public static void firsthDesign() 
    {
        EditorPainter.firsthDesign();
    }
    
    public static void drawLine() 
    {
        EditorPainter.drawLine();
    }
    
    public static void drawCircle()
    {
        EditorPainter.drawCircle();
    }
    
    public static void drawPoint()
    {
        EditorPainter.drawPoint();
    }
    public static void UpdateCircle(int pValue)
    {
        EditorPainter.UpdateRadius(pValue);
    }
    public static void clear(){
        EditorPainter.getListFigures().clear();
        EditorPainter.getListEdges().clear();
        EditorPainter.firsthDesign();
    }

    private Proram_Mode _ModeType;
    private static PaintAdministrator _PainterLogic;
    private Dictionary<Proram_Mode, LogicController> _Painters;
}