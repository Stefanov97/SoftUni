import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\thirdOutput.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {
            String line = br.readLine();
            while (line != null) {
                line = line.toUpperCase();
                writer.write(line);
                writer.write(System.lineSeparator());
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
