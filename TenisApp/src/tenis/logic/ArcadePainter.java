/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.logic;

import java.awt.Color;
import tenis.library.Design;

/**
 *
 * @author Rodrigo
 */
public class ArcadePainter implements IPainter {

    @Override
    public void pintar(Design pDesign) {
        System.out.println("Imprimendo en modo Arcade");
        //pDesign.getFiguras();
        //Debe realizarse para todas las Figuras en Design
        //boundaryFloodFill(pDesign.getFiguras().getX(), pDesign.getFiguras().getY());
   }
    
    public void boundaryFloodFill(int pPosX, int pPosY, Color pNewColor) {
        //Coloree el pixel inicial, revise el color de la posición actual
        boundaryFloodFill(pPosX + 1, pPosY, pNewColor);
        boundaryFloodFill(pPosX - 1, pPosY, pNewColor);
        boundaryFloodFill(pPosX, pPosY + 1, pNewColor);
        boundaryFloodFill(pPosX, pPosY + 1, pNewColor);
    }
    
}
