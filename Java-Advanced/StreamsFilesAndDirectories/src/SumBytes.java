import java.io.*;

public class SumBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\secondOutput.txt";
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {
            String line = br.readLine();
            while (line != null) {
                char[] symbols = line.toCharArray();
                for (char symbol : symbols) {
                    sum += symbol;
                }
                line = br.readLine();
            }
            writer.write(sum + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
