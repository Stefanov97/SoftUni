import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {

        String pathIn = "C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";
        List<String> forbidden = new ArrayList<>();
        forbidden.add(",");
        forbidden.add("!");
        forbidden.add("?");
        forbidden.add(".");

        try (FileInputStream fis = new FileInputStream(pathIn);
             FileOutputStream fos = new FileOutputStream(pathOut)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (!forbidden.contains((char) oneByte + "")) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
