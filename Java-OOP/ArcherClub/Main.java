import enums.Gender;
import models.archers.Archer;
import models.archers.JuniorArcher;
import models.archers.SeniorArcher;
import models.archers.VeteranArcher;
import models.bows.*;
import models.clubs.ArcherClub;

import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ArcherClub archerClub = new ArcherClub("TALANTS", "8-mi dekemvri", "Pavel");
        Random random = new Random();
        int index = 0;
        String[] genders = new String[]{"MALE", "FEMALE"};
        String[] names = new String[]{"Archer1", "Archer2", "Archer3", "Archer4", "Archer5", "Archer6", "Archer7", "Archer8", "Archer9", "Archer10",
                "Archer11", "Archer12", "Archer13", "Archer14", "Archer15", "Archer16", "Archer17", "Archer18", "Archer19", "Archer20",
                "Archer21", "Archer22", "Archer23", "Archer24", "Archer25", "Archer26", "Archer27", "Archer28", "Archer29", "Archer30",
                "Archer31", "Archer32", "Archer33", "Archer34", "Archer35", "Archer36", "Archer37", "Archer38", "Archer39", "Archer40"};
        String[] archerType = new String[]{"Junior", "Senior", "Veteran"};
        String[] bowType = new String[]{"Aluminium", "Carbon"};
        for (int i = 1; i <= 40; i++) {
            Gender gender = Gender.valueOf(genders[random.nextInt(2)]);
            int age = random.nextInt(39) + 12;
            String type = archerType[random.nextInt(3)];
            Archer archer = null;
            switch (type) {
                case "Junior": {
                    int strength = random.nextInt(9) + 20;
                    WoodenBow bow = new WoodenBow(UUID.randomUUID().toString(), i * 2, strength);
                    archer = new JuniorArcher(names[index++], gender, age, bow);
                    break;
                }
                case "Senior": {
                    SpecialBow bow = null;
                    String typeOfBow = bowType[random.nextInt(2)];
                    int experience = random.nextInt(6) + 3;

                    if (typeOfBow.equals("Aluminium")) {
                        int strength = random.nextInt(14) + 25;
                        bow = new AluminiumBow(UUID.randomUUID().toString(), i * 6, strength);
                    } else {
                        int strength = random.nextInt(19) + 28;
                        bow = new CarbonBow(UUID.randomUUID().toString(), i * 7, strength);
                    }
                    archer = new SeniorArcher(names[index++], gender, age, bow, experience);
                    break;
                }
                case "Veteran":
                    int veteranAge = random.nextInt(31) + 20;
                    int strength = random.nextInt(19) + 28;
                    int experience = veteranAge - 12;
                    CarbonBow bow = new CarbonBow(UUID.randomUUID().toString(), i * 5, strength);
                    archer = new VeteranArcher(names[index++], gender, veteranAge, bow, experience);
                    break;
            }
            archerClub.addArcher(archer);
        }
        System.out.println(archerClub.startTournament());
    }
}
