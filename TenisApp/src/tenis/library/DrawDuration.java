/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.library;

/**
 * Saves information about the dateduration of an algorithm
 * and the respective algorithm.
 * @author L. Antonio Hidalgo
 */
public class DrawDuration {
    private DateDuration _DateDuration;
    private DrawType _Algorithm;

    public DrawDuration(DateDuration pDuration, DrawType pAlgorithm) {
        _DateDuration = pDuration;
        _Algorithm = pAlgorithm;
    }
    
    public DateDuration getDateDuration() {
        return _DateDuration;
    }

    public void setDateDuration(DateDuration pDuration) {
        _DateDuration = pDuration;
    }

    public DrawType getAlgorithm() {
        return _Algorithm;
    }

    public void setAlgorithm(DrawType pAlgorithm) {
        _Algorithm = pAlgorithm;
    }
  
}
