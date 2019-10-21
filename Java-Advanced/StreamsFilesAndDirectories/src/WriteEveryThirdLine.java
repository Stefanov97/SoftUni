import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String pathIn = "C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\Pavel\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";
        int count = 1;
        try (BufferedReader in = new BufferedReader(new FileReader(pathIn));
             PrintWriter out = new PrintWriter(new FileWriter(pathOut))) {
            String line = in.readLine();
            while (line != null) {

                if (count % 3 == 0) {
                    out.write(line);
                    out.write(System.lineSeparator());
                }
                line = in.readLine();
                count++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
