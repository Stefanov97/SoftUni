package loggerLibrary.interfaces;

import loggerLibrary.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportlevel, String message);
    void setReportLevel(ReportLevel reportLevel);
}
