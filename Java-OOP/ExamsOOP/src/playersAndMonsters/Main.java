package playersAndMonsters;
import playersAndMonsters.core.ManagerControllerImpl;
import playersAndMonsters.core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerController controller = new ManagerControllerImpl();

        String line = scanner.nextLine();

        while (!"Exit".equals(line)){
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String message ="";
            switch (command){
                case "AddPlayer":
                    String playerType = tokens[1];
                    String playerName = tokens[2];
                    message = controller.addPlayer(playerType,playerName);
                    break;
                case "AddCard": {
                    String cardType = tokens[1];
                    String cardName = tokens[2];
                    message = controller.addCard(cardType, cardName);
                    break;
                }
                case "AddPlayerCard":
                    String username = tokens[1];
                    String cardName = tokens[2];
                    message = controller.addPlayerCard(username,cardName);
                    break;

                case "Fight":
                    String attackUser = tokens[1];
                    String enemyUser = tokens[2];
                    message = controller.fight(attackUser,enemyUser);
                    break;
                case "Report":
                    message = controller.report();
                    break;
            }
            System.out.println(message);
            line = scanner.nextLine();
        }
    }
}
