package messageQueue.models;

import java.util.*;
public class Topic {

    private String topicName;

    private List<Partition> partitionList;

    public Topic(String topicName){
        this.topicName = topicName;
        this.partitionList = new ArrayList<>();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Partition> getPartitionList() {
        return partitionList;
    }

    public void setPartitionList(List<Partition> partitionList) {
        this.partitionList = partitionList;
    }
}
