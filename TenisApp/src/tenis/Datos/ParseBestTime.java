package tenis.Datos;

import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;


/**
 * Inherits from ParseObject to have default names
 * for the DrawDuration object that will be saved in the
 * parse database.
 * @author L. Antonio Hidalgo
 */
@ParseClassName("ParseBestTimeObject")
public class ParseBestTime extends ParseObject {
    public ParseBestTime () {       
    }
    
    public void setDesignName(String pDesignName) {
        put("Name", pDesignName);
    }
    
    public String getDesignName() {
        return getString("Name");
    }
    
    public void setFireDrawDuration(String pDurationFire) {
        put("Date_Elapsed_time_Fire", pDurationFire);
    }
    
    public String getFireDrawDuration() {
        return getString("Date_Elapsed_time_Fire");
    }
    
    public void setArcadeDrawDuration(String pDurationArcade) {
        put("Date_Elapsed_time_Arcade", pDurationArcade);
    }
    
    public String getArcadeDrawDuration() {
        return getString("Date_Elapsed_time_Arcade");
    }
}