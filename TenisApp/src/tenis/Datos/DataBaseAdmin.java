package tenis.Datos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Design;
import org.parse4j.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.parse4j.util.ParseRegistry;


//Prueba
import tenis.library.Figure;
import tenis.library.Figure_Kind;
import java.awt.Color;
import java.awt.Point;
import org.parse4j.callback.FindCallback;


/**
 *
 * @author L. Antonio Hidalgo
 */
public class DataBaseAdmin {
    //private List<Design> _DesignList;
    private List<Figure> _FigureListPRUEBA = new ArrayList<Figure>();
    private Gson _ObjectToJsonConverter = new Gson();
    public static ParseDesignObject testObject = new ParseDesignObject();
    
    private void fillDesignList(Figure pPruebaFigure) {
        _FigureListPRUEBA.add(pPruebaFigure);
    }
    
    private void convertToJson() throws ParseException {
        String json1 = _ObjectToJsonConverter.toJson(_FigureListPRUEBA.get(0));
        System.out.println(json1);
        String json2 = _ObjectToJsonConverter.toJson(_FigureListPRUEBA.get(1));
        System.out.println(json2);
        //ParseObject(Design.getName()) Salva el nombre de la clase como un objeto completamente distinto
        //Segunda parte debe estar en un método de salvar
        //Se llama 2 veces para que todo quede en el mismo objeto
        testObject.setDesignName("Design1");
        testObject.put("Figure1", json1); //El nombre se obtiene de Design.getname()
        testObject.put("Figure2", json2);
        testObject.save();
        
    }
    
    private void convertFromJson() {
        //Primera parte debe convertirse en un método de getFromParse()
        ParseQuery<ParseDesignObject> query = ParseQuery.getQuery(ParseDesignObject.class);
        //Checks for objects of the ParseDesignObject class, that have the Name attribute set
        query.whereExists("Name");
        query.findInBackground(new FindCallback<ParseDesignObject>() {
            @Override
            public void done(List<ParseDesignObject> designList, ParseException exception) {
                Figure figureFromJson;
                String json;
                for(ParseDesignObject design : designList) {
                    
                }
            }
        });
    }
    
    private void parseTest() {
        
        testObject.add("Diseno1", _FigureListPRUEBA.get(0));
        try {
            testObject.save();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(testObject);
        
    }
    public static void main(String[] args) throws ParseException {
        ParseRegistry.registerSubclass(ParseDesignObject.class);
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
