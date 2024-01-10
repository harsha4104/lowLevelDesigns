package pubSub.subscriber;

public class SubscriberImpl implements Subscriber{

    private int id;

    private String name;
    @Override
    public void update(String msg) {
        System.out.println("Subscriber "+name+" updated with "+msg);
    }

    public SubscriberImpl(int id, String name){
        this.id = id;
        this.name = name;
    }
}
