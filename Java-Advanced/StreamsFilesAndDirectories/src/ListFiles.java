import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        Path pathIn = Paths.get("C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File file = new File(String.valueOf(pathIn));
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                System.out.println(String.format("%s: [%d]", files[i].getName(), files[i].length()));

            }
        }
    }
}
