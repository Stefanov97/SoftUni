package militaryElite;

import militaryElite.*;
import militaryElite.enums.Corps;
import militaryElite.enums.State;
import militaryElite.helperClasses.MissionImpl;
import militaryElite.helperClasses.RepairImpl;
import militaryElite.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Soldier> soldiers = new ArrayList<>();

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Private":
                    Private priv = createPrivate(tokens);
                    soldiers.add(priv);
                    break;
                case "LeutenantGeneral":
                    LieutenantGeneral general = createLieutenantGeneral(tokens, soldiers);
                    soldiers.add(general);

                    break;
                case "Engineer": {
                    boolean isValidCorps = true;
                    String corpString = tokens[5];
                    if (!corpString.equals("Airforces") && !corpString.equals("Marines")) {
                        isValidCorps = false;
                    }
                    if (isValidCorps) {
                        Engineer engineer = createEngineer(tokens);
                        soldiers.add(engineer);
                    }
                    break;
                }
                case "Commando":
                    boolean isValidCorps = true;
                    String corpString = tokens[5];
                    if (!corpString.equals("Airforces") && !corpString.equals("Marines")) {
                        isValidCorps = false;
                    }
                    if (isValidCorps) {
                        Commando commando = createCommando(tokens);
                        soldiers.add(commando);
                    }

                    break;
                case "Spy":
                    Spy spy = CreateSpy(tokens);
                    soldiers.add(spy);
                    break;
            }
            line = scanner.nextLine();
        }
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }

    private static Commando createCommando(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Corps corps = Corps.valueOf(tokens[5]);
        Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);
        for (int i = 6; i < tokens.length; i += 2) {
            String codeName = tokens[i];
            String stringState = tokens[i + 1];
            if (stringState.equals("inProgress") || stringState.equals("Finished")) {
                State state = State.valueOf(stringState);
                Mission mission = new MissionImpl(codeName, state);
                commando.addMission(mission);
            }
        }
        return commando;
    }

    private static Engineer createEngineer(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Corps corps = Corps.valueOf(tokens[5]);
        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
        for (int i = 6; i < tokens.length; i += 2) {
            String partName = tokens[i];
            int hoursWorked = Integer.parseInt(tokens[i + 1]);
            Repair repair = new RepairImpl(partName, hoursWorked);
            engineer.addRepair(repair);
        }

        return engineer;
    }

    private static Spy CreateSpy(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        int codeNumber = Integer.parseInt(tokens[4]);
        Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
        return spy;
    }

    private static LieutenantGeneral createLieutenantGeneral(String[] tokens, List<Soldier> soldiers) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        LieutenantGeneral general = new LieutenantGeneralImpl(id, firstName, lastName, salary);
        for (int i = 5; i < tokens.length; i++) {
            int privateId = Integer.parseInt(tokens[i]);
            for (Soldier soldier : soldiers) {
                if (soldier.getId() == privateId) {
                    general.addPrivate((Private) soldier);
                }
            }
        }
        return general;
    }

    private static Private createPrivate(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        Private priv = new PrivateImpl(id, firstName, lastName, salary);
        return priv;
    }
}
