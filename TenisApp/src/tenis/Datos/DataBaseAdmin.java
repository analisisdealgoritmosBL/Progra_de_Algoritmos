package tenis.Datos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tenis.library.Design;
import org.parse4j.*;
import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.parse4j.util.ParseRegistry;
import org.parse4j.callback.FindCallback;
import tenis.library.Background;
import tenis.library.DateDuration;
import tenis.library.Edge;

//Pruebas
import tenis.library.Figure;
import tenis.library.Figure_Kind;


/**
 *
 * @author L. Antonio Hidalgo
 */
public final class DataBaseAdmin {
    
    private Gson _ObjectJsonConverter = new Gson();
    public static ParseDesignObject testObject = new ParseDesignObject();
    public static Design _DesignList;
    
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
    
    public void setDesignList(Design pDesign) {
        _DesignList = pDesign;
    }
    
    private void saveDesignToDatabase(Design pDesign) throws ParseException {
        ParseDesignObject transitionalObjectToSave = new ParseDesignObject();
        
        transitionalObjectToSave.setDesignName(pDesign.getName());
        transitionalObjectToSave.setDesignCircles(convertListToJson(pDesign.getCircles()));
        transitionalObjectToSave.setDesignLines(convertListToJson(pDesign.getLines()));
        transitionalObjectToSave.setDesignBackgrounds(convertListToJson(pDesign.getBackgrounds()));
        transitionalObjectToSave.setDesignDateTime(convertToJson(pDesign.getDuration()));
        
        System.out.println(transitionalObjectToSave);
        
        transitionalObjectToSave.save();
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
    
    public List<Design> getDesignsFromDatabase() {
        List<Design> retrievedDesigns = new ArrayList<Design>();
        
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
                       // figureFromJson = _ObjectJsonConverter.fromJson(json, Figure.class);
                        System.out.println("Figure");
                        //System.out.println(figureFromJson);
                    }
                }
                else {
                    System.out.println("Object retrieval failed!");
                }
            }
        });
        return retrievedDesigns;
    }
            
    private void convertFromJson() {
        //Primera parte debe convertirse en un método de getFromParse()
        
    }
    
    public static void main(String[] args) throws ParseException {
        //ParseRegistry.registerSubclass(ParseDesignObject.class);
        //Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        Point xy = new Point(2,3);
        Figure testCircle = new Figure(xy, 3, Color.blue, Figure_Kind.Circle, 1);
        Edge testLine = new Edge(testCircle, testCircle, Figure_Kind.Line, 6, 7);
        Background testBG = new Background(xy.x, xy.y, Color.blue);
        Date testDate = new Date();
        
        //DateDuration testDD = new DateDuration(testDate, 180L);
        Design design1 = new Design("Prueba1", testCircle, testLine, testBG, testDate, 190L);
        DataBaseAdmin asd = new DataBaseAdmin();
        asd.getInstance();
        asd.setDesignList(design1);
        asd.saveDesignToDatabase(design1);
        //Point p = new Point(2,3);
        //Figure prueba1 = new Figure(p, 3, Color.blue, Figure_Kind.Line);
        //Figure prueba2 = new Figure(2, 3, 4, 5, Figure_Kind.Circular);
        //asd.fillDesignList(prueba1);
        //asd.fillDesignList(prueba2);
        //asd.convertToJson();
        //asd.convertToJson();
        //asd.convertFromJson();
        
        /*try {
            testObject.delete();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
