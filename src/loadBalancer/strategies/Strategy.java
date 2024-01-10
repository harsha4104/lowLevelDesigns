package loadBalancer.strategies;

import loadBalancer.model.Request;
public interface Strategy {

    public int getloadBalancerId(Request request);
}
