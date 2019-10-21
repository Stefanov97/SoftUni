import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\fourthOutput.txt";
        String vowels = "aeiou";
        String punctuation = "?!.,";
        int vowelsCount = 0;
        int punctCount = 0;
        int consonants = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {

            String line = br.readLine();
            while (line != null) {
                char[] chars = line.toCharArray();
                for (char symbol : chars) {
                    if (vowels.contains(symbol + "")) {
                        vowelsCount++;
                    } else if (punctuation.contains(symbol + "")) {
                        punctCount++;
                    } else {
                        if (symbol != ' ') {
                            consonants++;
                        }
                    }
                }

                line = br.readLine();
            }
            writer.write("Vowels: " + vowelsCount);
            writer.write(System.lineSeparator());
            writer.write("Consonants: " + consonants);
            writer.write(System.lineSeparator());
            writer.write("Punctuation: " + punctCount);
            writer.write(System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
