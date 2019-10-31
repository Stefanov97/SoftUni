package loggerLibrary.interfaces;

public interface Layout {
    String format(String date, ReportLevel reportlevel, String message);
}
