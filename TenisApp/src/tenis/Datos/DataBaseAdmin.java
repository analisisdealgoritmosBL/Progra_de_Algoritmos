package tenis.Datos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Design;
import org.parse4j.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.parse4j.util.ParseRegistry;
import org.parse4j.callback.FindCallback;


/**
 *
 * @author L. Antonio Hidalgo
 */
public final class DataBaseAdmin {
    
    private Gson _ObjectJsonConverter = new Gson();
    public static ParseDesignObject testObject = new ParseDesignObject();
    
    //This Database Administrator is created using the Singleton Pattern
    private static DataBaseAdmin _DBInstance = null;
    private DataBaseAdmin() { };
    
    public static synchronized DataBaseAdmin getInstance() {
        if(_DBInstance == null) {
            //If there are no instances of DB, one should be created
            _DBInstance = new DataBaseAdmin();
            
            //The ParseDesignObject and ParseBestTimeObject classes have to be registered prior to Parse initialization
            ParseRegistry.registerSubclass(ParseDesignObject.class);
            ParseRegistry.registerSubclass(ParseBestTimeObject.class);
            
            //Parse initialization should occur only once, in this case when DataBaseAdmin is instantiated.
            //Both arguments are provided by Parse, and they correspond to APP_ID and APP_REST_API_ID according
            //to https://github.com/thiagolocatelli/parse4j/blob/master/README.md parse4j documentation.
            Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        }
        return _DBInstance;
    }
    
    private void saveDesignToDatabase(Design pDesign) throws ParseException {
        ParseDesignObject transitionalObjectToSave = new ParseDesignObject();
        
        transitionalObjectToSave.setDesignName(pDesign.getName());
        transitionalObjectToSave.setDesignCircles(convertListToJson(pDesign.getCircles()));
        transitionalObjectToSave.setDesignLines(convertListToJson(pDesign.getLines()));
        transitionalObjectToSave.setDesignBackgrounds(convertListToJson(pDesign.getDesignBackgrounds()));
        
    }
    
    
    /*private void fillDesignList(Figure pPruebaFigure) {
        _FigureListPRUEBA.add(pPruebaFigure);
    }*/
    
    private String convertListToJson(List<?> pGenericObjectList) throws ParseException {
        String jsonString = new String();
        
        for(Object objectToConvert : pGenericObjectList) {
            jsonString += convertToJson(objectToConvert);
        }
        
        return jsonString;
    }
    
    private String convertToJson(Object pGenericObject) {
        String jsonString = new String();
        
        jsonString = _ObjectJsonConverter.toJson(pGenericObject);
        return jsonString;
    }
        
        /*String json1 = _ObjectJsonConverter.toJson(_FigureListPRUEBA.get(0));
        System.out.println(json1);
        //String json2 = _ObjectToJsonConverter.toJson(_FigureListPRUEBA.get(1));
        //System.out.println(json2);
        //ParseObject(Design.getName()) Salva el nombre de la clase como un objeto completamente distinto
        //Segunda parte debe estar en un método de salvar
        //Se llama 2 veces para que todo quede en el mismo objeto
        testObject.setDesignName("Design1");
        testObject.put("Figure1", json1); //El nombre se obtiene de Design.getname()
        //testObject.put("Figure2", json2);
        testObject.save();*/
        
    
    private void convertFromJson() {
        //Primera parte debe convertirse en un método de getFromParse()
        ParseQuery<ParseDesignObject> parseDesignQuery = ParseQuery.getQuery(ParseDesignObject.class);
        //Checks for objects of the ParseDesignObject class, that have the Name attribute set
        parseDesignQuery.whereExists("Name");
        parseDesignQuery.findInBackground(new FindCallback<ParseDesignObject>() {
            @Override
            public void done(List<ParseDesignObject> designList, ParseException exception) {
                //Figure figureFromJson;
                String json = new String();
                
                if(exception == null) {
                    for(ParseDesignObject design : designList) {
                        json = design.getString("Figure1");
                        System.out.println("Json:");
                        System.out.println(json);
                        figureFromJson = _ObjectJsonConverter.fromJson(json, Figure.class);
                        System.out.println("Figure");
                        System.out.println(figureFromJson);
                    }
                }
                else {
                    System.out.println("Object retrieval failed!");
                }
            }
        });
    }
    
    private void parseTest() {
        
        //testObject.add("Diseno1", _FigureListPRUEBA.get(0));
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
        //Point p = new Point(2,3);
        //Figure prueba1 = new Figure(p, 3, Color.blue, Figure_Kind.Line);
        //Figure prueba2 = new Figure(2, 3, 4, 5, Figure_Kind.Circular);
        //asd.fillDesignList(prueba1);
        //asd.fillDesignList(prueba2);
        //asd.convertToJson();
        //asd.convertToJson();
        asd.convertFromJson();
        
        /*try {
            testObject.delete();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
