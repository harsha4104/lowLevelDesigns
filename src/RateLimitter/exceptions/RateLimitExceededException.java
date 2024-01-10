package RateLimitter.exceptions;

public class RateLimitExceededException extends Exception{

    public RateLimitExceededException(String msg){
        super(msg);
    }
}
