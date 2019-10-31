package loggerLibrary;

import loggerLibrary.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportlevel, String message) {
        if(super.getReportlevel().compareTo(reportlevel)<= 0) {
            this.messagesAppended++;
            System.out.println(super.getLayout().format(date, reportlevel, message));
        }
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        super.setReportLevel(reportLevel);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
