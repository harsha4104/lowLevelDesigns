package loadBalancer.loadBalancer;

import loadBalancer.strategies.Strategy;
import loadBalancer.model.*;

public class LoadBalancerImpl implements LoadBalancer{

    Strategy strategy;

    public LoadBalancerImpl(Strategy strategy){
        this.strategy = strategy;
    }

    @Override
    public int getLoadBalancer(Request request) {
        return strategy.getloadBalancerId(request);
    }
}
