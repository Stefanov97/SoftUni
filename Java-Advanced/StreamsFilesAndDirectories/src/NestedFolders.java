import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NestedFolders {
    static int count = 1;

    public static void main(String[] args) {
        Path pathIn = Paths.get("C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File file = new File(String.valueOf(pathIn));
        printAllDocs(file);
        System.out.println(String.format("%d folders", count));


    }

    static void printAllDocs(File file) {
        if (file == null) return;

        File[] files = file.listFiles();
        if (files == null) return;
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("DIR:");
                System.out.println(f.getName());
                count++;
                printAllDocs(f);
            }
        }
    }
}
