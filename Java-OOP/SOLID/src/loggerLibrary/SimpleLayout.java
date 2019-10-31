package loggerLibrary;

import loggerLibrary.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportlevel, String message) {
        return String.format("%s - %s - %s", date, reportlevel, message);
    }
}
