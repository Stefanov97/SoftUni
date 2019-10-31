package loggerLibrary;

import loggerLibrary.interfaces.Appender;
import loggerLibrary.interfaces.Layout;
import loggerLibrary.interfaces.Logger;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Appender[] appenders = new Appender[n];
        int index = 0;
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String appenderType = tokens[0];
            String layoutType = tokens[1];
            Appender appender = null;
            Layout layout = null;
            switch (layoutType) {
                case "SimpleLayout":
                    layout = new SimpleLayout();
                    break;
                case "XmlLayout":
                    layout = new XmlLayout();
                    break;
            }
            switch (appenderType) {
                case "ConsoleAppender":
                    appender = new ConsoleAppender(layout);
                    break;
                case "FileAppender":
                    appender = new FileAppender(layout);
                    break;
            }
            if (tokens.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
            }
            appenders[index++] = appender;
        }

        String line = scanner.nextLine();
        Logger logger = new MessageLogger(appenders);
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String date = tokens[1];
            String message = tokens[2];
            switch (reportLevel) {
                case INFO:
                    logger.logInfo(date, message);
                    break;
                case ERROR:
                    logger.logError(date, message);
                    break;
                case FATAL:
                    logger.logFatal(date, message);
                    break;
                case WARNING:
                    logger.logWarning(date, message);
                    break;
                case CRITICAL:
                    logger.logCritical(date, message);
                    break;
            }

            line = scanner.nextLine();
        }
        System.out.println("Logger info");
        for (Appender appender : appenders) {
            System.out.println(appender.toString());
        }

    }
}
