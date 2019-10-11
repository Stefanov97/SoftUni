import java.util.Scanner;

public class HogsWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int initialPresents = Integer.parseInt(scanner.nextLine());
        int initial = initialPresents;

        int timesWentBack = 0;
        int additionalPresents = 0;

        for (int i = 1; i <= n; i++) {

            int presentsToGive = Integer.parseInt(scanner.nextLine());

            if (initialPresents - presentsToGive < 0) {
                timesWentBack++;
                additionalPresents += (initial / i) * ((n - i)) + (presentsToGive - initialPresents);
                int addtitional = (initial / i) * ((n - i)) + (presentsToGive - initialPresents);
                initialPresents += addtitional - presentsToGive;

            } else {
                initialPresents -= presentsToGive;
            }
        }

        if (timesWentBack == 0) {
            System.out.println(initialPresents);
        } else {
            System.out.println(timesWentBack);
            System.out.println(additionalPresents);
        }
    }
}
