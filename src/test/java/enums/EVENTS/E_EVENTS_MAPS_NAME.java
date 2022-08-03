package enums.EVENTS;

public enum E_EVENTS_MAPS_NAME {



    MAPNAME("mapMap", "multiMap", "supermapMap");

    private final String getAllRow_writeIndexThenColumnName;
    private final String getAllColumn_writeColumnName ;
    private final String supermapMap;


    E_EVENTS_MAPS_NAME(String getAllRow_writeIndexThenColumnName, String getAllColumn_writeColumnName, String supermapMap) {
        this.getAllRow_writeIndexThenColumnName = getAllRow_writeIndexThenColumnName;
        this.getAllColumn_writeColumnName = getAllColumn_writeColumnName;
        this.supermapMap = supermapMap;
    }

    public String getAllRow_writeIndexThenColumnName() {
        return getAllRow_writeIndexThenColumnName;
    }

    public String getAllColumn_writeColumnName() {
        return getAllColumn_writeColumnName;
    }

    public String getSupermapMap() {
        return supermapMap;
    }
}

