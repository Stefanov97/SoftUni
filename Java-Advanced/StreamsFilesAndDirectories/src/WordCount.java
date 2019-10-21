import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String secondInputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\sixthOutput.txt";
        Map<String, Integer> result = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedReader br2 = new BufferedReader(new FileReader(secondInputPath));
             FileWriter writer = new FileWriter(outputPath)) {

            String[] keyTextLine = br.readLine().split("\\s");
            for (String key : keyTextLine) {
                //key=key.toLowerCase();
                result.put(key, 0);
            }
            String[] line = br2.readLine().split("\\s");
            for (String word : line) {
                // word=word.toLowerCase();
                if (result.containsKey(word)) {
                    result.put(word, result.get(word) + 1);
                }
            }
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                String word = entry.getKey();
                int times = entry.getValue();
                writer.write(String.format("%s - %d", word, times));
                writer.write(System.lineSeparator());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
