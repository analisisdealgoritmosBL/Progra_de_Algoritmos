package tenis.Datos;

import java.util.List;
import tenis.library.Design;
import org.parse4j.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.awt.Point;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.parse4j.util.ParseRegistry;
import org.parse4j.callback.FindCallback;
import tenis.library.Background;
import tenis.library.DateDuration;
import tenis.library.DrawDuration;
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
    private List<Design> _DesignList = new ArrayList<>();
    
    //This Database Administrator is created using the Singleton Pattern
    private static DataBaseAdmin _DBInstance = null;
    private DataBaseAdmin() { };
    
    public static synchronized DataBaseAdmin getInstance() {
        if(_DBInstance == null) {
            //If there are no instances of DB, one should be created
            _DBInstance = new DataBaseAdmin();
            
            //The ParseDesignObject and ParseBestTimeObject classes have to be registered prior to Parse initialization
            ParseRegistry.registerSubclass(ParseDesign.class);
            ParseRegistry.registerSubclass(ParseBestTime.class);
            
            //Parse initialization should occur only once, in this case when DataBaseAdmin is instantiated.
            //Both arguments are provided by Parse, and they correspond to APP_ID and APP_REST_API_ID according
            //to https://github.com/thiagolocatelli/parse4j/blob/master/README.md parse4j documentation.
            Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        }
        return _DBInstance;
    }
    
    private void saveDesignToDatabase(Design pDesign) {
        ParseDesign dummyObjectToSave = new ParseDesign();
        
        dummyObjectToSave.setDesignName(pDesign.getName());
        dummyObjectToSave.setDesignCircles(convertToJson(pDesign.getCircles()));
        dummyObjectToSave.setDesignLines(convertToJson(pDesign.getLines()));
        dummyObjectToSave.setDesignBackgrounds(convertToJson(pDesign.getBackgrounds()));
        dummyObjectToSave.setFireDuration(convertToJson(pDesign.getFireDuration()));
        dummyObjectToSave.setArcadeDuration(convertToJson(pDesign.getArcadeDuration()));
        
        try {
            dummyObjectToSave.save();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String convertToJson(List<?> pGenericObjectList) {
        String jsonString = new String();
        
        jsonString = _ObjectJsonConverter.toJson(pGenericObjectList);
        return jsonString;
    }
    
    private <T> String convertToJson(T pGenericObject) {
        String jsonString = new String();
        
        jsonString = _ObjectJsonConverter.toJson(pGenericObject);
        return jsonString;
    }
            
    private DrawDuration convertDrawDurationFromJson(String pJsonString) {
        DrawDuration drawDurationFromJson;
        
        drawDurationFromJson = _ObjectJsonConverter.fromJson(pJsonString, DrawDuration.class);
        
        return drawDurationFromJson;
    }
    
    private List<Figure> convertFigureListFromJson(String pJsonString) {
        List<Figure> figureListFromJson = new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Figure>>(){}.getType();
       
        figureListFromJson = _ObjectJsonConverter.fromJson(pJsonString, collectionType);
        return figureListFromJson;
    }
    
    private List<Edge> convertLineListFromJson(String pJsonString) {
        List<Edge> lineListFromJson = new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Edge>>(){}.getType();
       
        lineListFromJson = _ObjectJsonConverter.fromJson(pJsonString, collectionType);
        return lineListFromJson;
    }
    
    private List<Background> convertBackgroundListFromJson(String pJsonString) {
        List<Background> backgroundListFromJson = new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Background>>(){}.getType();
       
        backgroundListFromJson = _ObjectJsonConverter.fromJson(pJsonString, collectionType);
        return backgroundListFromJson;
    }
    
    public List<Design> getDesignsFromDatabase() {
        findDesignsInDatabase();
        return _DesignList;
    }
    private void findDesignsInDatabase() {
        ParseQuery<ParseDesign> parseDesignQuery = ParseQuery.getQuery(ParseDesign.class);
        
        //Checks for objects of the ParseDesignObject class that have the Name attribute set
        parseDesignQuery.whereExists("Name");
        try {
            
            if(parseDesignQuery.find() != null)
                buildDesignListFromQuery(parseDesignQuery.find());

            /*
            //The findInBackground method fails to fetch the ParseDesign Objects
            //quickly enough to be processed.
            parseDesignQuery.findInBackground(new FindCallback<ParseDesign>() {
            @Override
            public void done(List<ParseDesign> pDesignList, ParseException pException) {
            if(pException == null) {
            //System.out.println(pDesignList.get(0).get("Name"));
            buildDesignListFromQuery(pDesignList);
            }
            else {
            System.out.println("Object retrieval failed!");
            }
            }
            });*/
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void buildDesignListFromQuery(List<ParseDesign> pDesignList) {
        Design retrievedDesign;
        
        for(ParseDesign design : pDesignList) {
            //A new Design is created with the results from the query
                        
            retrievedDesign = new Design(design.getDesignName(),
                convertFigureListFromJson(design.getDesignCircles()), 
                convertLineListFromJson(design.getDesignLines()), 
                convertBackgroundListFromJson(design.getDesignBackgrounds()),
                convertDrawDurationFromJson(design.getFireDuration()),
                convertDrawDurationFromJson(design.getArcadeDuration())
                );
                _DesignList.add(retrievedDesign);

        }
    }
    
    private void saveBestDrawTime(Design pDesign) {
        ParseBestTime dummyObjectToSave = new ParseBestTime();
        
        dummyObjectToSave.setDesignName(pDesign.getName());
        dummyObjectToSave.setFireDrawDuration(convertToJson(pDesign.getFireDuration()));
        dummyObjectToSave.setArcadeDrawDuration(convertToJson(pDesign.getArcadeDuration()));
        
        try {
            dummyObjectToSave.save();
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<DrawDuration> findBestDrawTimesInDataBase(Design pDesign) {
        ParseBestTime currentBestTime = new ParseBestTime();
        ParseQuery<ParseBestTime> parseBestTimeQuery = ParseQuery.getQuery(ParseBestTime.class);
        DrawDuration currentBestDrawDurationForDesign;
        List<DrawDuration> bestDrawDurationsForDesign = new ArrayList<>();
        
        
        //Checks for objects of the ParseDesignObject class that have the Name attribute set
        parseBestTimeQuery.whereEqualTo("Name", pDesign.getName());
        try {
            if(parseBestTimeQuery.find() != null) {
                bestDrawDurationsForDesign = buildDrawDurationFromQuery(parseBestTimeQuery.find());
            }
            else {
                saveBestDrawTime(pDesign);
                bestDrawDurationsForDesign.add(pDesign.getArcadeDuration());
                bestDrawDurationsForDesign.add(pDesign.getFireDuration());
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(DataBaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bestDrawDurationsForDesign;
    }
    
    private List<DrawDuration> buildDrawDurationFromQuery(List<ParseBestTime> pBestTimes) {
        DrawDuration currentBestDrawDurationForDesign;
        List<DrawDuration> bestDrawDurationFromQuery = new ArrayList<>();

        for(ParseBestTime bestTime : pBestTimes) {
            //A new DrawDuration is created with the results from the query
            
            currentBestDrawDurationForDesign = new DrawDuration(convertDrawDurationFromJson(bestTime.getFireDrawDuration()).getDateDuration(),
                convertDrawDurationFromJson(bestTime.getFireDrawDuration()).getAlgorithm());
            
            bestDrawDurationFromQuery.add(currentBestDrawDurationForDesign);
        }
        return bestDrawDurationFromQuery;
    }
    
    public static void main(String[] args) {
        //ParseRegistry.registerSubclass(ParseDesignObject.class);
        //Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        Point xy = new Point(2,3);
        Figure testCircle = new Figure(xy, 3, Color.blue, Figure_Kind.Circle, 1);
        Edge testLine = new Edge(testCircle, testCircle, Figure_Kind.Line, 6, 7);
        Background testBG = new Background(xy.x, xy.y, Color.blue);
        Date testDate = new Date();
        
        //DateDuration testDD = new DateDuration(testDate, 180L);
        Design design1 = new Design("Prueba1", testCircle, testLine, testBG, testDate, 190L, testDate, 200L);
        DataBaseAdmin asd = new DataBaseAdmin();
        List<Design> testList = new ArrayList<>();
        List<DrawDuration> drawList = new ArrayList<>();
        
        asd.getInstance();
        //asd.saveDesignToDatabase(design1);
        drawList = asd.findBestDrawTimesInDataBase(design1);
        testList = asd.getDesignsFromDatabase();
        System.out.println(testList.get(0).getFireDuration().getDateDuration().getDuration());
        
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
