package logger.logger;

import logger.enums.LogType;
import logger.enums.SinkType;

public interface Logger {

    void log(LogType logType, SinkType sinkType, String msg);
}
