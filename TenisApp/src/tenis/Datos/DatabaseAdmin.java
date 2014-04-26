package tenis.Datos;

import java.util.List;
import tenis.library.Design;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseQuery;
import org.parse4j.util.ParseRegistry;
import tenis.library.Background;
import tenis.library.DrawDuration;
import tenis.library.DrawType;
import tenis.library.Edge;

//Pruebas
import tenis.library.Figure;



/**
 * This Database Administrator is created using the Singleton Pattern.
 * It connects to a Parse account, using thiagolocatelli's parse4j library.
 * @author L. Antonio Hidalgo
 */
public final class DatabaseAdmin {
    
    private Gson _ObjectJsonConverter = new Gson();
    private List<Design> _DesignList = new ArrayList<>();
    private Map<String, HashMap<DrawType, DrawDuration>> _BestDrawTimes = new HashMap<String, HashMap<DrawType, DrawDuration>>();
    
    private static DatabaseAdmin _DBInstance = null;
    /**
     * Empty constructor to avoid unwanted instances.
     */
    private DatabaseAdmin() { };
    
    /**
     * Singleton "constructor".
     * @return 
     */
    public static synchronized DatabaseAdmin getInstance() {
        if(_DBInstance == null) {
            //If there are no instances of DB, one should be created
            _DBInstance = new DatabaseAdmin();
            
            //The ParseDesignObject and ParseBestTimeObject classes have to be registered prior to Parse initialization
            ParseRegistry.registerSubclass(ParseDesign.class);
            ParseRegistry.registerSubclass(ParseBestTime.class);
            
            //Parse initialization should occur only once, in this case when DatabaseAdmin is instantiated.
            //Both arguments are provided by Parse, and they correspond to APP_ID and APP_REST_API_ID according
            //to https://github.com/thiagolocatelli/parse4j/blob/master/README.md parse4j documentation.
            Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        }
        return _DBInstance;
    }
    /**
     * Saves a design to the parse database.
     * @param pDesign 
     */
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
            Logger.getLogger(DatabaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Converts a generic list of objects from their respective classes to
     * a json representation.
     * @param pGenericObjectList
     * @return String json representation.
     */
    private String convertToJson(List<?> pGenericObjectList) {
        String jsonString = new String();
        
        jsonString = _ObjectJsonConverter.toJson(pGenericObjectList);
        return jsonString;
    }
    
    /**
     * Converts a type T object from its class to a json representation.
     * @param <T>
     * @param pGenericObject
     * @return 
     */
    private <T> String convertToJson(T pGenericObject) {
        String jsonString = new String();
        
        jsonString = _ObjectJsonConverter.toJson(pGenericObject);
        return jsonString;
    }
    
    /**
     * Converts a json string to a DrawDuration object.
     * @param pJsonString
     * @return DrawDuration object.
     */
    private DrawDuration convertDrawDurationFromJson(String pJsonString) {
        DrawDuration drawDurationFromJson;
        
        drawDurationFromJson = _ObjectJsonConverter.fromJson(pJsonString, DrawDuration.class);
        
        return drawDurationFromJson;
    }
    
    /**
     * Converts a json string to a Figure List.
     * @param pJsonString
     * @return Figure List.
     */
    private List<Figure> convertFigureListFromJson(String pJsonString) {
        List<Figure> figureListFromJson = new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Figure>>(){}.getType();
       
        figureListFromJson = _ObjectJsonConverter.fromJson(pJsonString, collectionType);
        return figureListFromJson;
    }
    
    /**Converts a json string to an Edge List.
     * 
     * @param pJsonString
     * @return Edge List.
     */
    private List<Edge> convertLineListFromJson(String pJsonString) {
        List<Edge> lineListFromJson = new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Edge>>(){}.getType();
       
        lineListFromJson = _ObjectJsonConverter.fromJson(pJsonString, collectionType);
        return lineListFromJson;
    }
    
    /**Converts a json string to a Background List.
     * 
     * @param pJsonString
     * @return Background List.
     */
    private List<Background> convertBackgroundListFromJson(String pJsonString) {
        List<Background> backgroundListFromJson = new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Background>>(){}.getType();
       
        backgroundListFromJson = _ObjectJsonConverter.fromJson(pJsonString, collectionType);
        return backgroundListFromJson;
    }
    
    /**
     * Gets Design List from the parse database.
     * @return Design List.
     */
    public List<Design> getDesignsFromDatabase() {
        findDesignsInDatabase();
        return _DesignList;
    }
    
    /**
     * Queries the database to find all the Design objects that have names, i.e. all of them.
     */
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
            Logger.getLogger(DatabaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fills the DatabaseAdmin class _DesignList attribute with the ParseDesign
     * query results.
     * @param pDesignList 
     */
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
    
    /**
     * Saves the BestDrawTime for a design.
     * @param pDesign 
     */
    private void saveBestDrawTime(Design pDesign) {
        ParseBestTime dummyObjectToSave = new ParseBestTime();
        
        dummyObjectToSave.setDesignName(pDesign.getName());
        dummyObjectToSave.setFireDrawDuration(convertToJson(pDesign.getFireDuration()));
        dummyObjectToSave.setArcadeDrawDuration(convertToJson(pDesign.getArcadeDuration()));
        
        try {
            dummyObjectToSave.save();
        } catch (ParseException ex) {
            Logger.getLogger(DatabaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fetches the BestDrawTimes from the parse database, for all the saved designs.
     * @return A HashMap of the DrawDuration objects for all of the designs currently in the database.
     */
    public Map<String, HashMap<DrawType, DrawDuration>> getBestDrawTimesFromDatabase() {
        HashMap<DrawType, DrawDuration> timesForDesign = new HashMap<>();
        
        if( !_DesignList.isEmpty())
            for(Design designInList : _DesignList) {
                timesForDesign = findBestDesignDrawTimeInDatabase(designInList);
                _BestDrawTimes.put(designInList.getName(), timesForDesign);
            }
        return _BestDrawTimes;
    }
    
    /**
     * Finds the BestDrawTime for a specific design in the database.
     * @param pDesign
     * @return A HashMap that relates DrawType with DrawDuration.
     */
    private HashMap<DrawType, DrawDuration> findBestDesignDrawTimeInDatabase(Design pDesign) {
        ParseBestTime currentBestTime = new ParseBestTime();
        ParseQuery<ParseBestTime> parseBestTimeQuery = ParseQuery.getQuery(ParseBestTime.class);
        HashMap<DrawType, DrawDuration> bestDrawDurationsForDesign = new HashMap<>();
        DrawDuration currentBestArcadeTime;
        DrawDuration currentBestFireTime;
        
        
        //Checks for objects of the ParseDesignObject class that have the Name attribute set
        parseBestTimeQuery.whereEqualTo("Name", pDesign.getName());
        try {
            if(parseBestTimeQuery.find() != null) {
                //The result is unique because the Design's name is also unique.
                //Since getFirst() is not implemented in parse4j, and it's known
                //that there has to be only one result, the following is valid, though not optimal:
                
                currentBestTime = parseBestTimeQuery.find().get(0);
                bestDrawDurationsForDesign = buildDrawDurationFromQuery(currentBestTime);
                
                currentBestArcadeTime = bestDrawDurationsForDesign.get(DrawType.Arcade);
                currentBestFireTime = bestDrawDurationsForDesign.get(DrawType.Fire);
                
                //Checks if pDesign's ArcadeDuration or FireDuration is lower (and better) than the one currently stored
                //and updates them if necessary
                
                updateBestDrawTime(pDesign, currentBestFireTime, currentBestArcadeTime);
            }
            else {
                //If it has not been initialized, the best times are the default
                saveBestDrawTime(pDesign);
                bestDrawDurationsForDesign.put(DrawType.Arcade, pDesign.getArcadeDuration());
                bestDrawDurationsForDesign.put(DrawType.Fire, pDesign.getFireDuration());
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(DatabaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bestDrawDurationsForDesign;
    }
    
    private HashMap<DrawType, DrawDuration> buildDrawDurationFromQuery(ParseBestTime pBestTimes) {
        DrawDuration currentBestDrawDurationForDesign;
        HashMap<DrawType, DrawDuration> bestDrawDurationFromQuery = new HashMap<>();
        
        //A new DrawDuration is created with the results from the query
        currentBestDrawDurationForDesign = new DrawDuration(convertDrawDurationFromJson(pBestTimes.getFireDrawDuration()).getDateDuration(),
            convertDrawDurationFromJson(pBestTimes.getFireDrawDuration()).getAlgorithm());
            
            bestDrawDurationFromQuery.put(DrawType.Fire, currentBestDrawDurationForDesign);
            
        currentBestDrawDurationForDesign = new DrawDuration(convertDrawDurationFromJson(pBestTimes.getArcadeDrawDuration()).getDateDuration(),
            convertDrawDurationFromJson(pBestTimes.getArcadeDrawDuration()).getAlgorithm());
        
            bestDrawDurationFromQuery.put(DrawType.Arcade, currentBestDrawDurationForDesign);
        
        return bestDrawDurationFromQuery;
    }
    
    private void updateBestDrawTime(Design pDesign, DrawDuration pCurrentBestFireTime, DrawDuration pCurrentBestArcadeTime) {
        ParseBestTime dummyObjectToSave = new ParseBestTime();
        Long currentDesignArcadeTime = pDesign.getArcadeDuration().getDateDuration().getDuration();
        Long currentDesignFireTime = pDesign.getFireDuration().getDateDuration().getDuration();
        Long currentBestFireTime = pCurrentBestFireTime.getDateDuration().getDuration();
        Long currentBestArcadeTime = pCurrentBestArcadeTime.getDateDuration().getDuration();
        
        dummyObjectToSave.setDesignName(pDesign.getName());
        
        if(currentDesignArcadeTime < currentBestArcadeTime)
            dummyObjectToSave.setArcadeDrawDuration(convertToJson(pDesign.getArcadeDuration()));
        else
            dummyObjectToSave.setArcadeDrawDuration(convertToJson(pCurrentBestArcadeTime));
        
        if(currentDesignFireTime < currentBestFireTime)
            dummyObjectToSave.setFireDrawDuration(convertToJson(pDesign.getFireDuration()));
        else
            dummyObjectToSave.setFireDrawDuration(convertToJson(pCurrentBestFireTime));
 
        try {
            dummyObjectToSave.save();
        } catch (ParseException ex) {
            Logger.getLogger(DatabaseAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public static void main(String[] args) {
        //ParseRegistry.registerSubclass(ParseDesignObject.class);
        //Parse.initialize("sWHeJhUcP8MMDStbDh2BcYu9AGfKqiPXIVfooZqQ", "FAu31BWoXqKV70BvEiVG2NSCyBo5CBve277vs915");
        Point xy = new Point(2,3);
        Figure testCircle = new Figure(xy, 3, Color.blue, FigureType.Circle, 1);
        Edge testLine = new Edge(testCircle, testCircle, FigureType.Line, 6, 7, Color.YELLOW);
        Background testBG = new Background(testCircle, Color.blue, FigureType.Point);
        Date testDate = new Date();
        
        //DateDuration testDD = new DateDuration(testDate, 180L);
        Design design1 = new Design("Prueba1", testCircle, testLine, testBG, testDate, 190L, testDate, 200L);
        DatabaseAdmin asd = new DatabaseAdmin();
        List<Design> testList = new ArrayList<>();
        Map<DrawType, DrawDuration> drawMap = new HashMap<>();
        
        asd.getInstance();
        asd.saveDesignToDatabase(design1);
        testList = asd.getDesignsFromDatabase();
        drawMap = asd.getBestDrawTimesFromDatabase().get("Prueba1");
        
        System.out.println(drawMap.get(DrawType.Arcade).getDateDuration().getDateTime());
        System.out.println(testList.get(0).getFireDuration().getDateDuration().getDuration());
        
    }*/
}
