package tenis.Datos;

import org.parse4j.ParseObject;
import org.parse4j.ParseClassName;


/**
 *
 * @author L. Antonio Hidalgo
 */
@ParseClassName("ParseDesignObject")
public class ParseDesignObject extends ParseObject {
    public ParseDesignObject() {
        
    }
    
    public void setDesignName(String pDesignName) {
        put("Nombre", pDesignName);
    }
    
    public String getDesignName() {
        return getString("Nombre");
    }
}
