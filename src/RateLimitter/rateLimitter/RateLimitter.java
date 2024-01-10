package RateLimitter.rateLimitter;

import RateLimitter.exceptions.RateLimitExceededException;
import RateLimitter.models.*;
public interface RateLimitter {

    void checkRateLimit(Request request) throws RateLimitExceededException;
}
