import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\fifthOutput.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {
            int lineNumber = 1;
            String line = br.readLine();
            while (line != null) {
                writer.write(String.format("%d. %s", lineNumber, line));
                writer.write(System.lineSeparator());
                lineNumber++;

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
