package RateLimitter;

import RateLimitter.exceptions.RateLimitExceededException;
import RateLimitter.models.Request;
import RateLimitter.rateLimitter.RateLimitter;
import RateLimitter.rateLimitter.RateLimitterStrategy;
import RateLimitter.storage.Storage;
import RateLimitter.storage.StorageImpl;

public class Executor {

    public static void main(String[] args){

        Storage storage = new StorageImpl();
        RateLimitter rateLimitter = new RateLimitterStrategy(storage, 1);

        Request request = new Request(1);

        try {
            rateLimitter.checkRateLimit(request);
            Thread.sleep(2000);
            rateLimitter.checkRateLimit(request);
            rateLimitter.checkRateLimit(request);
        }
        catch(RateLimitExceededException rex){
            System.out.println(rex.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
