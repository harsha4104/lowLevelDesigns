package messageQueue.impl;

public class Consumer {

    private String consumerName;
    public void consumeMessage(String msg) {
        System.out.println(consumerName+" reads "+msg);
    }

    public Consumer(String consumerName) {
        this.consumerName = consumerName;
    }


    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }
}
