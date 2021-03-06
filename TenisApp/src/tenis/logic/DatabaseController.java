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
public class DatabaseController {
    private List<Design> _FetchedDesignList = new ArrayList<>();
    private Map<String, HashMap<DrawType, DrawDuration>> _FetchedBestDrawTimes = new HashMap<String, HashMap<DrawType, DrawDuration>>();
    private List<Design> _SavedDesignList = new ArrayList<>();
    private DatabaseAdmin _ProjectDatabase;

    public DatabaseController() {
        _ProjectDatabase = DatabaseAdmin.getInstance();
    }

    public void setFetchedDesignList(List<Design> _FetchedDesignList) {
        this._FetchedDesignList = _FetchedDesignList;
    }
    
    public List<Design> getFetchedDesignList() {
        return _FetchedDesignList;
    }

    public Map<String, HashMap<DrawType, DrawDuration>> getFetchedBestDrawTimes() {
        return _FetchedBestDrawTimes;
    }

    public void setFetchedBestDrawTimes(Map<String, HashMap<DrawType, DrawDuration>> _FetchedBestDrawTimes) {
        this._FetchedBestDrawTimes = _FetchedBestDrawTimes;
    }

    public void setSavedDesignList(List<Design> _SavedDesignList) {
        this._SavedDesignList = _SavedDesignList;
    }
    
    public void getDesignsFromDatabase() {
        _FetchedDesignList = _ProjectDatabase.getDesignsFromDatabase();
    }
    
    public void getBestDrawTimesFromDatabase() {
        setFetchedBestDrawTimes(_ProjectDatabase.getBestDrawTimesFromDatabase());
    }
    
    public void saveDesignsToDatabase() {
        _ProjectDatabase.saveDesignsToDatabase(_SavedDesignList);
    }

}
