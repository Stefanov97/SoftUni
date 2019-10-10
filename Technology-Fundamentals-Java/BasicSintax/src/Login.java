import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine(); //acer
        String password = "";


        for (int i = user.length() - 1; i >= 0; i--) {
            char letter = user.charAt(i);
            password += letter;
        }

        int counter = 0;
        boolean isBlocked = false;
        String input = scanner.nextLine();
        while (!input.equals(password)) {

            counter++;
            if (counter > 3) {
                System.out.printf("User %s blocked!", user);
                isBlocked = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();

        }
        if (!isBlocked) {
            System.out.printf("User %s logged in.", user);
        }
    }
}
