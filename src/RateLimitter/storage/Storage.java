package RateLimitter.storage;

import RateLimitter.models.*;
import java.util.*;
public interface Storage {

    void addRequest(Request request);

    Queue<Long> getRequestList(Request request);

}
