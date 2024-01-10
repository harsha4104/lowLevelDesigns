package pubSub;

import pubSub.eventManager.EventManager;
import pubSub.eventType.EventType;
import pubSub.subscriber.SubscriberImpl;

import pubSub.event.*;

public class Executor {

    public static void main(String[] args){

        SubscriberImpl subscriberOne = new SubscriberImpl(1, "Harsh");

        SubscriberImpl subscribertwo = new SubscriberImpl(2, "Jay");

        SubscriberImpl subscriberthree = new SubscriberImpl(3, "Deeksha");

        EventManager eventManager = new EventManager();

        eventManager.subscribe(EventType.INSERT, subscriberOne);
        eventManager.subscribe(EventType.INSERT, subscriberthree);
        eventManager.subscribe(EventType.UPDATE, subscribertwo);

        Event event = new FirstEvent(eventManager);

        event.publish(EventType.INSERT, "Something is inserted");
        event.publish(EventType.UPDATE, "Something is updated");

    }
}
