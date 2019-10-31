package loggerLibrary;

import loggerLibrary.interfaces.Appender;
import loggerLibrary.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportlevel = ReportLevel.INFO;
    Integer messagesAppended = 0;
    public AppenderImpl(Layout layout){
        this.layout=layout;
    }

    public Layout getLayout() {
        return layout;
    }

    public ReportLevel getReportlevel() {
        return reportlevel;
    }

    public Integer getMessagesAppended() {
        return messagesAppended;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel){
        this.reportlevel = reportLevel;
    }
    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",this.getClass().getSimpleName(),this.layout.getClass().getSimpleName(),this.reportlevel,this.messagesAppended);
    }

}
