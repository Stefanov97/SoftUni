import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String pathIn = "C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        try (Scanner scanner = new Scanner(new FileReader(pathIn));
             FileWriter fr = new FileWriter(pathOut)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    //System.out.println(scanner.nextInt());
                    String digitToString = String.valueOf(scanner.nextInt());
                    for (int i = 0; i < digitToString.length(); i++) {
                        fr.write(digitToString.charAt(i));
                    }
                    fr.write(System.lineSeparator());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
