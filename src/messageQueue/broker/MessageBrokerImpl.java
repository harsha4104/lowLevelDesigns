package messageQueue.broker;

import messageQueue.exceptions.*;
import messageQueue.impl.*;

import messageQueue.models.Partition;
import messageQueue.models.Topic;
import messageQueue.worker.*;

import java.util.*;
public class MessageBrokerImpl implements MessageBroker{

    Map<String, Topic> topicMap;

    Map<String, List<Consumer>>  partitionConsumerMap;


    public MessageBrokerImpl(){
        topicMap = new HashMap<>();
        partitionConsumerMap = new HashMap<>();
    }

    @Override
    public void publishMessageToPartition(String topicName, String partitionName, String msg) throws TopicNameNotExist, PartitionNotExist {

        if(topicMap.get(topicName) == null){
            throw new TopicNameNotExist("TopicName Does not Exist");
        }
        else{
           Partition partition = null;

           for(Partition partition1: topicMap.get(topicName).getPartitionList()){
               if(partition1.getPartitionName() == partitionName){
                   partition = partition1;
                   break;
               }
           }

           if(partition == null){
               throw new PartitionNotExist("PartitionName Does Not Exist");
           }
           List<String> messageList = partition.getMessageList();
           messageList.add(msg);
        }
    }

    public void addTopic(String topicName, Topic topic){

        topicMap.put(topicName, topic);
    }

    public void removeTopic(String topicName){
        topicMap.remove(topicName);
    }

    public void addPartition(Partition partition, String topicName){
        List<Partition> partitions = topicMap.get(topicName).getPartitionList();
        partitions.add(partition);

    }

    public void removePartition(Partition partition, String topicName){
        List<Partition> partitions = topicMap.get(topicName).getPartitionList();
        if(partitions == null){
            return;
        }
        partitions.remove(partition);
    }

    public void subscribe(String topicName, String partitionName, Consumer consumer){
        List<Partition> partitions = topicMap.get(topicName).getPartitionList();

        if(partitions == null){
            return;
        }

        for(int i=0;i<partitions.size();i++){
            if(partitions.get(i).getPartitionName() == partitionName){
                ConsumerWorker consumerWorker = new ConsumerWorker(consumer, partitions.get(i));
                Thread t = new Thread(consumerWorker);
                t.start();
            }
        }
    }
}
