/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import tenis.library.Design;

/**
 *
 * @author Rodrigo
 */
public class ArcadePainter implements IPainter {

    @Override
    public void pintar(Design pDesign) {
        System.out.println("Imprimendo en modo Arcade");
    }
    
}
