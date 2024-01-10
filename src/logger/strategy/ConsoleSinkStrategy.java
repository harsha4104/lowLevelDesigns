package logger.strategy;

import logger.enums.LogType;
public class ConsoleSinkStrategy implements  SinkStrategy{


    @Override
    public void sinkMessage(LogType logType, String msg) {
        System.out.println(logType.toString()+" : "+msg);
    }

}
