package pubSub.event;

import pubSub.eventManager.EventManager;
import pubSub.eventType.EventType;

public abstract class Event {

    EventManager eventManager;

    public Event(EventManager eventManager){
        this.eventManager = eventManager;
    }
    public void publish(EventType eventType, String msg){
        eventManager.publish(eventType, msg);
    }
}
