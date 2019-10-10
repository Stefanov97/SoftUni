import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int indexExtension = input.indexOf(".");
        int indexFiileName = input.lastIndexOf("\\");
        String fileName = input.substring(indexFiileName + 1, indexExtension);
        String extension = input.substring(indexExtension + 1);

        System.out.println(String.format("File name: %s", fileName));
        System.out.println(String.format("File extension: %s", extension));

    }
}
