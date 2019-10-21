import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondInputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\seventhOutput.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedReader br2 = new BufferedReader(new FileReader(secondInputPath));
             FileWriter writer = new FileWriter(outputPath)) {

            String line = br.readLine();
            while (line != null) {
                writer.write(line);
                writer.write(System.lineSeparator());
                line = br.readLine();
            }
            String secondLIne = br2.readLine();
            while (secondLIne != null) {
                writer.write(secondLIne);
                writer.write(System.lineSeparator());
                secondLIne = br2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
