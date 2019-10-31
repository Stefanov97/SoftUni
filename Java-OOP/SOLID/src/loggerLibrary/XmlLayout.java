package loggerLibrary;

import loggerLibrary.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportlevel, String message) {
        return String.format("<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>", date, reportlevel, message);
    }
}
