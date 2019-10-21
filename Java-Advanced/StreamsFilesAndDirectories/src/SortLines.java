import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        Path pathIn = Paths.get("C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathOut = Paths.get("C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        List<String> inputLines = Files.readAllLines(pathIn).stream().filter(line -> !line.isEmpty()).collect(Collectors.toList());
        Collections.sort(inputLines);

        Files.write(pathOut, inputLines);
    }
}
