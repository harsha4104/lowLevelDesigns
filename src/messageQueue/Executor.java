package messageQueue;

import messageQueue.broker.MessageBroker;
import messageQueue.broker.MessageBrokerImpl;
import messageQueue.exceptions.PartitionNotExist;
import messageQueue.exceptions.TopicNameNotExist;
import messageQueue.impl.Consumer;
import messageQueue.impl.ProducerImpl;
import messageQueue.interfaces.Producer;
import messageQueue.models.Partition;
import messageQueue.models.Topic;

public class Executor {

    public static void main(String[] args) throws PartitionNotExist, TopicNameNotExist {

        Topic topic1 = new Topic("Harsh");
        Partition partition = new Partition("First");
        Partition partition2 = new Partition("First");
        Topic topic2 = new Topic("Deeksha");


        Consumer consumer = new Consumer("Jay");

        MessageBroker messageBroker = new MessageBrokerImpl();
        messageBroker.addTopic(topic1.getTopicName(),topic1);
        messageBroker.addPartition(partition, topic1.getTopicName());
        messageBroker.addTopic(topic2.getTopicName(),topic2);
        messageBroker.addPartition(partition2, topic2.getTopicName());

        messageBroker.subscribe(topic1.getTopicName(), partition.getPartitionName(), consumer);
        messageBroker.subscribe(topic2.getTopicName(), partition2.getPartitionName(), consumer);

        Producer producer = new ProducerImpl(messageBroker);


        producer.publishMessage("Harsh", "First", "Hi, I'm harsh");
        producer.publishMessage("Deeksha", "First", "Hi, I'm Deeksha");
    }
}
