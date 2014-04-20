/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenis.Datos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Design;
import org.parse4j.*;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class DataBaseAdmin {
    private List<Design> designList;
    
    private void parseTest() {
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        try {
            testObject.save();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        DataBaseAdmin asd = new DataBaseAdmin();
        asd.parseTest();
    }
}
