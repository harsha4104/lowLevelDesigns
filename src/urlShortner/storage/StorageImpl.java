package urlShortner.storage;

import java.util.HashMap;
import java.util.*;

public class StorageImpl implements Storage{

    Map<String, String> map;

    public StorageImpl(){
        this.map = new HashMap<>();
    }
    @Override
    public void storeUrl(String hashValue, String url) {
        map.put(hashValue, url);
    }

    @Override
    public void removeUrl(String hashValue) {
        map.remove(hashValue);
    }

    @Override
    public String getUrl(String hashValue) {
        return map.get(hashValue);
    }
}
