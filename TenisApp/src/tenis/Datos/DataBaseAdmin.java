package tenis.Datos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Design;
import org.parse4j.*;
import com.google.gson.Gson;

import tenis.library.Figure; //PRUEBA
import tenis.library.Figure_Kind;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class DataBaseAdmin {
    //private List<Design> _DesignList;
    private List<Figure> _FigureListPRUEBA = new ArrayList<Figure>();
    private Gson _ObjectToJsonConverter = new Gson();
    public static ParseObject testObject;
    
    private void fillDesignList(Figure pPruebaFigure) {
        _FigureListPRUEBA.add(pPruebaFigure);
    }
    
    private void convertToJson() {
        String json = _ObjectToJsonConverter.toJson(_FigureListPRUEBA.get(0));
        System.out.println(json);
    }
    
    private void parseTest() {
        testObject = new ParseObject("TestObject");
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
        Point p = new Point(2,3);
        Figure prueba1 = new Figure(p, 3, Color.blue, Figure_Kind.Line);
        Figure prueba2 = new Figure(2, 3, 4, 5, Figure_Kind.Circular);
        asd.fillDesignList(prueba1);
        asd.fillDesignList(prueba2);
        asd.convertToJson();
        
        /*try {
            testObject.delete();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
