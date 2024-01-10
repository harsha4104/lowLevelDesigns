package messageQueue.worker;

import messageQueue.impl.Consumer;
import messageQueue.models.Partition;

public class ConsumerWorker implements Runnable{

    Consumer consumer;

    private int offSet = 0;
    Partition partition;

    public ConsumerWorker(Consumer consumer, Partition partition){
        this.consumer = consumer;
        this.partition = partition;
    }
    @Override
    public void run() {

        while(true){
            while(offSet >= partition.getMessageList().size());
            consumer.consumeMessage(partition.getMessageList().get(offSet));
            offSet +=1;
        }
    }
}
