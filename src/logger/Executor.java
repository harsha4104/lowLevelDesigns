package logger;

import logger.enums.LogType;
import logger.enums.SinkType;
import logger.logconfiguration.LogConfiguration;
import logger.logger.Logger;
import logger.logger.LoggerImpl;
import logger.strategy.ConsoleSinkStrategy;
import logger.strategy.SinkStrategy;

public class Executor {

    public static void main(String[] args){

        SinkStrategy console = new ConsoleSinkStrategy();

        Logger logger  = new LoggerImpl();
        LogConfiguration.addSinkStrategy(SinkType.CONSOLE, console);

        logger.log(LogType.ERROR, SinkType.CONSOLE, "there is a error");

    }
}
