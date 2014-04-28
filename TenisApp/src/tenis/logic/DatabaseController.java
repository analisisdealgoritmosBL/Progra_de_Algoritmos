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

    public void setFetchedBestDrawTimes(Map<String, HashMap<DrawType, DrawDuration>> _FetchedBestDrawTimes) {
        this._FetchedBestDrawTimes = _FetchedBestDrawTimes;
    }

    public List<Design> getSavedDesignList() {
        return _SavedDesignList;
    }

    public void setSavedDesignList(List<Design> _SavedDesignList) {
        this._SavedDesignList = _SavedDesignList;
    }

    public List<Design> getDesignsFromDatabase() {
        setFetchedDesignList(_ProjectDatabase.getDesignsFromDatabase());
        return _FetchedDesignList;
    }
    
    public Map<String, HashMap<DrawType, DrawDuration>> getBestDrawTimesFromDatabase() {
        setFetchedBestDrawTimes(_ProjectDatabase.getBestDrawTimesFromDatabase());
        return _FetchedBestDrawTimes;
    }
    
    public void saveDesignsToDatabase() {
        _ProjectDatabase.saveDesignsToDatabase(_SavedDesignList);
    }

}
