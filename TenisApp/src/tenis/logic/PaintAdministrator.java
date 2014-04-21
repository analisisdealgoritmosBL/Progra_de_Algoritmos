/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import tenis.library.Design;
import tenis.library.Figure;
import tenis.library.Figure_Kind;
import tenis.library.Proram_Mode;

/**
 *
 * @author Rodrigo
 */
public class PaintAdministrator 
{
    

    private PaintAdministrator() 
    {
        _Painters = new Hashtable<Proram_Mode, IPainter>();
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
        IPainter painter = _Painters.get(_ModeType);
        painter.pintar(pDesino);
    }
    
    public void setMode(Proram_Mode pMode)
    {
        _ModeType = pMode;
    }
    
    public static void newDesign() 
    {
        
    }
    
    public static void firsthDesignPoints(Point mousePt, Figure_Kind kind, int radius, List<Figure> nodes) 
    {
        Figure.selectNone(nodes);
        Point p = mousePt.getLocation();
        Figure n = new Figure(p, radius, Color.BLUE, kind);
        n.setSelected(true);
        nodes.add(n);
    }
    public static void firsthDesignLines(int x1, int x2, int x3, int x4, Figure_Kind kind, List<Figure> nodes) 
    {
        Figure.selectNone(nodes);
        Figure n = new Figure(x1, x2, x3, x4, kind);
        n.setSelected(true);
        nodes.add(n);
    }
    public static void firsthDesignCurves(Point point1,Point curve,Point point2, Figure_Kind kind, List<Figure> nodes) 
    {
        Figure.selectNone(nodes);
        Figure n = new Figure(point1,curve,point2,kind);
        n.setSelected(true);
        nodes.add(n);
    }
    
   
    public List<Figure> _nodes = new ArrayList<>();
    private Proram_Mode _ModeType;
    private static PaintAdministrator _PainterLogic;
    private Dictionary<Proram_Mode, IPainter> _Painters;
}
