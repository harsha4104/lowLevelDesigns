package messageQueue.exceptions;

public class PartitionNotExist extends Exception{

    public PartitionNotExist(String msg){
        super(msg);
    }
}
