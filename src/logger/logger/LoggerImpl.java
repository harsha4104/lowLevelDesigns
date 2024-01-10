package logger.logger;

import logger.enums.LogType;
import logger.enums.SinkType;
import logger.logconfiguration.LogConfiguration;
import logger.strategy.SinkStrategy;

public class LoggerImpl implements  Logger{

    LogConfiguration logConfiguration = LogConfiguration.getInstance();

    @Override
    public void log(LogType logType, SinkType sinkType, String msg) {

        SinkStrategy sinkStrategy = LogConfiguration.getSinkStrategyByType(sinkType);
        sinkStrategy.sinkMessage(logType, msg);
    }
}
