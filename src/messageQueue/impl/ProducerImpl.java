package messageQueue.impl;

import messageQueue.broker.MessageBroker;
import messageQueue.exceptions.PartitionNotExist;
import messageQueue.exceptions.TopicNameNotExist;
import messageQueue.interfaces.Producer;

public class ProducerImpl implements Producer {

    MessageBroker messageBroker;

    public ProducerImpl(MessageBroker messageBroker){
        this.messageBroker = messageBroker;
    }
    @Override
    public void publishMessage(String topicName, String partitionName, String msg) throws TopicNameNotExist, PartitionNotExist {
        messageBroker.publishMessageToPartition(topicName, partitionName, msg);
    }
}
