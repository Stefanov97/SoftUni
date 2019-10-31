package loggerLibrary;

import loggerLibrary.interfaces.File;
import loggerLibrary.interfaces.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }


    @Override
    public void append(String date, ReportLevel reportlevel, String message) {
        if (super.getReportlevel().compareTo(reportlevel) <= 0) {
            this.messagesAppended++;
            String messageToAppend = super.getLayout().format(date, reportlevel, message);
            this.file.write(messageToAppend);
        }
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        super.setReportLevel(reportLevel);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", this.file.getSize());
    }
}
