package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;
        for (String url : this.urls) {
            for (char c : url.toCharArray()) {
                if (Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                sb.append("Browsing: " + url + "!").append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        boolean isValid = true;
        for (String number : this.numbers) {
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                sb.append("Calling... " + number).append(System.lineSeparator());
            } else {
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
