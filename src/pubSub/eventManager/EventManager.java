package pubSub.eventManager;

import pubSub.eventType.*;
import pubSub.subscriber.Subscriber;
import java.util.*;

public class EventManager {

    Map<EventType, List<Subscriber>> map;

    public EventManager(){
        map = new HashMap<>();
    }

    public void publish(EventType eventType, String msg){
        List<Subscriber> list = map.get(eventType);
        for(Subscriber s: list){
            s.update(msg);
        }
    }

    public void subscribe(EventType eventType, Subscriber subscriber){
        List<Subscriber> list = map.getOrDefault(eventType, new ArrayList<>());
        list.add(subscriber);
        map.put(eventType, list);
    }

    public void unsubscribe(EventType eventType, Subscriber subscriber){
        List<Subscriber> list = map.get(eventType);
        if(list == null){
            list.remove(subscriber);
        }
    }
}
