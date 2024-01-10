package messageQueue.broker;

import messageQueue.exceptions.PartitionNotExist;
import messageQueue.exceptions.TopicNameNotExist;
import messageQueue.impl.Consumer;
import messageQueue.models.Partition;
import messageQueue.models.Topic;

public interface MessageBroker {

    void publishMessageToPartition(String topicName, String partitionName, String msg) throws TopicNameNotExist, PartitionNotExist;

    void addTopic(String topicName, Topic topic);

    void removeTopic(String topicName);

    void addPartition(Partition partition, String topicName);

    void removePartition(Partition partition, String topicName);

    void subscribe(String topicName, String partitionName, Consumer consumer);
}
