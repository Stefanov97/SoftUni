package loggerLibrary;

import loggerLibrary.interfaces.File;

public class LogFile implements File {
    private StringBuilder buffer;

    public LogFile() {
        this.buffer = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.buffer.append(message).append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (char c : this.buffer.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sum += c;
            }
        }

        return sum;
    }
}
