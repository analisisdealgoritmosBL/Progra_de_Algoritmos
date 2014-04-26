package tenis.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tenis.Datos.DatabaseAdmin;
import tenis.library.Design;
import tenis.library.DrawDuration;
import tenis.library.DrawType;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class MainController {
    private List<Design> _DesignList = new ArrayList<>();
    private Map<String, HashMap<DrawType, DrawDuration>> _BestDrawTimes = new HashMap<String, HashMap<DrawType, DrawDuration>>();
    private DatabaseAdmin _ProjectDatabase = DatabaseAdmin.getInstance();
    
    
}
