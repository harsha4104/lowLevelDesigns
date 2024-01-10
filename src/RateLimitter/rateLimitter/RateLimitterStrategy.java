package RateLimitter.rateLimitter;

import RateLimitter.exceptions.RateLimitExceededException;
import RateLimitter.models.Request;
import RateLimitter.storage.Storage;
import RateLimitter.storage.StorageImpl;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.Locale;

public class RateLimitterStrategy implements RateLimitter{

    Storage storage;

    int rateLimit;

    public RateLimitterStrategy(Storage storage, int rateLimit){
        this.storage = storage;
        this.rateLimit = rateLimit;
    }
    @Override
    public void checkRateLimit(Request request) throws RateLimitExceededException {
        Queue<Long> list = storage.getRequestList(request);

        if(list == null){
            storage.addRequest(request);
        }
        else{
            while(!list.isEmpty()) {
                Duration duration = Duration.ofNanos(LocalTime.now().getNano() - list.peek());
                if (duration.getNano()/100000 > 1000) {
                    list.poll();
                }
                else{
                    break;
                }
            }

            if(list.size() >= rateLimit){
                throw new RateLimitExceededException("Rate Limit Exceeded");
            }
            else{
                storage.addRequest(request);
            }
        }
    }
}
