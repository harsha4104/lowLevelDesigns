package messageQueue.interfaces;

import messageQueue.exceptions.PartitionNotExist;
import messageQueue.exceptions.TopicNameNotExist;

public interface Producer {

    void publishMessage(String topicName, String partitionName, String msg) throws TopicNameNotExist, PartitionNotExist;
}
