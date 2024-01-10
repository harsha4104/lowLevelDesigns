package loadBalancer.loadBalancer;

import loadBalancer.model.Request;

public interface LoadBalancer {

    int getLoadBalancer(Request request);
}
