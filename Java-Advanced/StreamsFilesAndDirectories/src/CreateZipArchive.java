import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Pavel\\IdeaProjects\\FunctionalProgramming\\src\\AddVat.java";
        String secondInputPath = "C:\\Users\\Pavel\\IdeaProjects\\FunctionalProgramming\\src\\ConsumerPrint.java";
        //  String thirdInputPath = "C:\\Users\\Pavel\\Desktop\\resourses\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\secondOutput.txt";
        String outputPath = "C:\\Users\\Pavel\\Desktop\\DefiningClasses Solutions\\zip.zip";

        try (FileOutputStream fos = new FileOutputStream(outputPath);
             FileInputStream fis = new FileInputStream(inputPath);
             FileInputStream fis2 = new FileInputStream(secondInputPath);
             // FileInputStream fis3 = new FileInputStream(thirdInputPath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            ZipEntry ze = new ZipEntry("AddVat.java");
            zos.putNextEntry(ze);
            zos.write(fis.readAllBytes());

            ZipEntry ze2 = new ZipEntry("ConsumerPrint.java");
            zos.putNextEntry(ze2);
            zos.write(fis2.readAllBytes());
            // ZipEntry ze3 = new ZipEntry("inputTwo.txt");
            // zos.putNextEntry(ze3);
            //zos.write(fis2.readAllBytes());

            //send data to zos;
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
