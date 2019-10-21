import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\eightOutput.txt";

        File file = new File(inputPath);
        File[] files = file.listFiles();
        int size = 0;
        for (File f : files) {
            long currSize = f.length();
            size += currSize;
        }
        System.out.println("Folder size: " + size);
    }
}
