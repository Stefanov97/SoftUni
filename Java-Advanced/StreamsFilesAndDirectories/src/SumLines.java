import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\firstOutput.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {
            String line = br.readLine();
            while (line != null) {
                char[] symbols = line.toCharArray();
                int sum = 0;
                for (char symbol : symbols) {
                    sum += symbol;
                }
                line = br.readLine();
                writer.write(sum + "");
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
