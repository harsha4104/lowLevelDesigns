package messageQueue.models;

import java.util.*;
public class Partition {

    private String partitionName;

    private List<String> messageList;


    public Partition(String partitionName) {
        this.partitionName = partitionName;
        this.messageList = new ArrayList<>();
    }

    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }
}
