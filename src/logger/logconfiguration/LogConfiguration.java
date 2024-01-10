package logger.logconfiguration;

import logger.enums.LogType;
import logger.enums.SinkType;
import logger.strategy.SinkStrategy;

import java.util.*;

public class LogConfiguration {

    private static LogConfiguration instance;

    private static Map<SinkType, SinkStrategy> map;

    private LogConfiguration(){
        this.map = new HashMap<>();
    }
    public static LogConfiguration getInstance(){
        if(instance == null) {
            synchronized (LogConfiguration.class) {
                if (instance == null) {
                    instance = new LogConfiguration();
                }
            }
        }
        return instance;
    }

    public static void addSinkStrategy(SinkType sinkType, SinkStrategy sinkStrategy){
        map.put(sinkType, sinkStrategy);
    }

    public static SinkStrategy getSinkStrategyByType(SinkType sinkType){
        return map.get(sinkType);
    }

}
