package tenis.Datos;

import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;


/**
 *
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
    
    public void setBestTime(long pBestDrawingTime) {
        put("Best Time", pBestDrawingTime);
    }
    
    public long getBestTime() {
        return getLong("Best Time");
    }
}