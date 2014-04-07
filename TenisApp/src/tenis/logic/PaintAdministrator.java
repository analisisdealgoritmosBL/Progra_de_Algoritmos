/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.util.Dictionary;
import java.util.Hashtable;
import tenis.library.Diseno;
import tenis.library.ModeTypes;

/**
 *
 * @author Rodrigo
 */
public class PaintAdministrator 
{
    private PaintAdministrator() 
    {
        _Painters = new Hashtable<ModeTypes, IPainter>();
        _Painters.put(ModeTypes.EDIT, new EditorPainter());
        _Painters.put(ModeTypes.ARCADE, new ArcadePainter());
        _Painters.put(ModeTypes.FIRE, new FirePainter());
    }
    
    public synchronized static PaintAdministrator getInstance() 
    {
        if (_PainterLogic==null)
        {
            _PainterLogic = new PaintAdministrator();
        }
        return _PainterLogic;
    }
    
    
    public void cargarDiseno(Diseno pDesino) 
    {
        IPainter painter = _Painters.get(_ModeType);
        painter.pintar(pDesino);
    }
    
    public void setMode(ModeTypes pMode)
    {
        _ModeType = pMode;
    }
    
    private ModeTypes _ModeType;
    private static PaintAdministrator _PainterLogic;
    private Dictionary<ModeTypes, IPainter> _Painters;
}
