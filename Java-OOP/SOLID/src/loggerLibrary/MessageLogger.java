package loggerLibrary;

import loggerLibrary.interfaces.Appender;
import loggerLibrary.interfaces.Logger;

public class MessageLogger implements Logger {
    Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }

    @Override
    public void logInfo(String date, String message) {
        log(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        log(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        log(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String date, String message) {
        log(date, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        log(date, ReportLevel.FATAL, message);
    }

    private void log(String date, ReportLevel reportlevel, String message) {
        for (Appender appender : this.appenders) {
            appender.append(date, reportlevel, message);
        }
    }
}
