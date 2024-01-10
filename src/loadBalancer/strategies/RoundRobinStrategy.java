package loadBalancer.strategies;

import loadBalancer.model.Server;
import loadBalancer.model.Request;

import java.util.*;

public class RoundRobinStrategy implements Strategy{

    Queue<Server> queue;

    public RoundRobinStrategy(List<Server> list){
        queue = new LinkedList<>();
        for(Server item: list){
            queue.add(item);
        }
    }
    @Override
    public int getloadBalancerId(Request request) {
        Server loadBalancer = queue.poll();
        queue.add(loadBalancer);
        return loadBalancer.getId();
    }
}
