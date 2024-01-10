package loadBalancer;

import loadBalancer.loadBalancer.LoadBalancerImpl;
import loadBalancer.model.Server;
import loadBalancer.model.Request;
import loadBalancer.strategies.RoundRobinStrategy;
import loadBalancer.strategies.Strategy;
import java.util.*;

import java.util.ArrayList;

public class Executor {

    public static void main(String[] args){

        Server loadBalancer = new Server(1, "first");
        Server loadBalancer1 = new Server(2, "second");
        Server loadBalancer2 = new Server(3, "third");
        Server loadBalancer3 = new Server(4, "fourth");
        List<Server> loadBalancerList = new ArrayList<>();
        loadBalancerList.add(loadBalancer);
        loadBalancerList.add(loadBalancer1);
        loadBalancerList.add(loadBalancer2);
        loadBalancerList.add(loadBalancer3);

        Strategy strategy = new RoundRobinStrategy(loadBalancerList);

        loadBalancer.loadBalancer.LoadBalancer loadBalance = new LoadBalancerImpl(strategy);

        System.out.println(loadBalance.getLoadBalancer(new Request(1)));
        System.out.println(loadBalance.getLoadBalancer(new Request(1)));
        System.out.println(loadBalance.getLoadBalancer(new Request(1)));
        System.out.println(loadBalance.getLoadBalancer(new Request(1)));
        System.out.println(loadBalance.getLoadBalancer(new Request(1)));
    }
}
