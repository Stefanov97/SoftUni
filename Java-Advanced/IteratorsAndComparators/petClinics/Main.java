import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //   try{
        //      Clinic clinic = new Clinic("asd",3);
        //   }catch (IllegalAccessException exp){
        //    System.out.println(exp.getMessage());
        //  }

        int n = Integer.parseInt(scanner.nextLine());
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    String whatToCreate = tokens[1];
                    if (whatToCreate.equals("Pet")) {
                        String name = tokens[2];
                        int age = Integer.parseInt(tokens[3]);
                        String kind = tokens[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.add(pet);
                    } else {
                        String name = tokens[2];
                        int rooms = Integer.parseInt(tokens[3]);
                        try {
                            Clinic clinic = new Clinic(name, rooms);
                            clinics.add(clinic);
                        } catch (IllegalAccessException exp) {
                            System.out.println(exp.getMessage());
                        }
                    }

                    break;

                case "Add":
                    String petName = tokens[1];
                    Pet petToAdd = new Pet("", 0, "");
                    String clinicName = tokens[2];
                    for (Pet pet : pets) {
                        if (pet.getName().equals(petName)) {
                            petToAdd = pet;
                            break;
                        }
                    }
                    Clinic clinicToBeAddedIn = null;
                    for (Clinic clinic : clinics) {
                        if (clinic.getName().equals(clinicName)) {
                            clinicToBeAddedIn = clinic;
                            break;
                        }
                    }
                    System.out.println(clinicToBeAddedIn.add(petToAdd));


                    break;
                case "Release":
                    String clinicsName = tokens[1];
                    Clinic clinicForRelease = null;
                    for (Clinic clinic : clinics) {
                        if (clinic.getName().equals(clinicsName)) {
                            clinicForRelease = clinic;
                            break;
                        }
                    }
                    System.out.println(clinicForRelease.Release());


                    break;

                case "Print":
                    String clinicNameToPrint = tokens[1];
                    Clinic clinicForPrint = null;
                    for (Clinic clinic : clinics) {
                        if (clinic.getName().equals(clinicNameToPrint)) {
                            clinicForPrint = clinic;
                            break;
                        }
                    }
                    if (tokens.length == 2) {
                        clinicForPrint.Print();
                    } else if (tokens.length > 2) {
                        int indexRoomToPrint = Integer.parseInt(tokens[2]) - 1;
                        clinicForPrint.Print(indexRoomToPrint);
                    }

                    break;
                case "HasEmptyRooms":
                    String clinicNameToCheck = tokens[1];
                    Clinic clinicToCheck = null;
                    for (Clinic clinic : clinics) {
                        if (clinic.getName().equals(clinicNameToCheck)) {
                            clinicToCheck = clinic;
                            break;
                        }
                    }
                    System.out.println(clinicToCheck.hasEmptyRooms());
                    break;

            }
        }
    }
}
