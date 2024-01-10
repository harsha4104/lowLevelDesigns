package logger.strategy;

import logger.enums.LogType;

public interface SinkStrategy {

    void sinkMessage(LogType LogType, String msg);
}
