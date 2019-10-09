import java.util.Scanner;

public class Grades {
    static void printInWords(double grade) {
        String gradeType = "";
        if (grade <= 2.99) {
            gradeType = "Fail";
        } else if (grade <= 3.49) {
            gradeType = "Poor";
        } else if (grade <= 4.49) {
            gradeType = "Good";
        } else if (grade <= 5.49) {
            gradeType = "Very good";
        } else {
            gradeType = "Excellent";
        }
        System.out.println(gradeType);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printInWords(grade);

    }
}
