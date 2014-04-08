/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.library;

/**
 *
 * @author Rodrigo
 */
public class Design {
    
    public String getName() 
    {
        return _Name;
    }
    
    public Figure getDots() 
    {
        return _Dots;
    }
    
    public Figure getLines() 
    {
        return _Lines;
    }
    
    public Figure getCircles() 
    {
        return _Circles;
    }
    
    public Figure getColors() 
    {
        return _Colors;
    }
    
    private String _Name;
    private Figure _Dots;
    private Figure _Lines;
    private Figure _Circles;
    private Figure _Colors;
}
