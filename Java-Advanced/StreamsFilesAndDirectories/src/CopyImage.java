import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CopyImage {
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        List<String> names = new ArrayList<>();
        names.add("1.jpg");
        names.add("2.jpg");
        names.add("3.jpg");
        names.add("4.jpg");
        try {
            String path = "C:\\Users\\Pavel\\Desktop\\Images\\Мария - бал\\3";
            File file = new File(path);
            File[] files = file.listFiles();
            for (File f : files) {
                is = new FileInputStream(f);
                os = new FileOutputStream(new File("C:\\Users\\Pavel\\Desktop\\" + f.getName()));

                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                names.remove(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
            os.close();
        }
    }
}
