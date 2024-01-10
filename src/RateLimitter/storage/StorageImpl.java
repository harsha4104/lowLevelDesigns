package RateLimitter.storage;

import RateLimitter.models.Request;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public class StorageImpl implements Storage{

    Map<Integer, Queue<Long>> map = new HashMap<>();

    public void addRequest(Request request) {
        if(map.containsKey(request.id)){
            Queue<Long> list = map.get(request.id);
            list.add(LocalTime.now().toNanoOfDay());
            map.put(request.id, list);
        }
        else{
            Queue<Long> list = new LinkedList<>();
            list.add(LocalTime.now().toNanoOfDay());
            map.put(request.id, list);
        }
    }

    @Override
    public Queue<Long> getRequestList(Request request) {

        return map.get(request.id);
    }


}
