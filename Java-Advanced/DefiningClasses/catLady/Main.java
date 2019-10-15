import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<SiameseCat> siameseCats = new ArrayList<>();
        List<CymricCat> cymricCats = new ArrayList<>();
        List<StreetExtraordinaireCat> streetExtraordinaireCats = new ArrayList<>();
        Map<String, String> catNameAndBreed = new LinkedHashMap<>();
        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];
            double specialFeature = Double.parseDouble(tokens[2]);

            switch (catType) {
                case "Siamese": {
                    SiameseCat cat = new SiameseCat(catName, specialFeature);
                    catNameAndBreed.put(catName, catType);
                    siameseCats.add(cat);
                    break;
                }
                case "Cymric": {
                    CymricCat cat = new CymricCat(catName, specialFeature);
                    catNameAndBreed.put(catName, catType);
                    cymricCats.add(cat);
                    break;
                }
                case "StreetExtraordinaire": {
                    StreetExtraordinaireCat cat = new StreetExtraordinaireCat(catName, specialFeature);
                    catNameAndBreed.put(catName, catType);
                    streetExtraordinaireCats.add(cat);
                    break;
                }
            }

            line = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        String catType = catNameAndBreed.get(nameToPrint);
        switch (catType) {
            case "Siamese": {
                for (SiameseCat cat : siameseCats) {
                    if (cat.getName().equals(nameToPrint)) {
                        System.out.println(String.format("%s %s %.2f", catType, cat.getName(), cat.getEarSize()));
                    }
                }
                break;
            }
            case "Cymric": {
                for (CymricCat cat : cymricCats) {
                    if (cat.getName().equals(nameToPrint)) {
                        System.out.println(String.format("%s %s %.2f", catType, cat.getName(), cat.getFurLength()));
                    }
                }

                break;
            }
            case "StreetExtraordinaire": {
                for (StreetExtraordinaireCat cat : streetExtraordinaireCats) {
                    if (cat.getName().equals(nameToPrint)) {
                        System.out.println(String.format("%s %s %.2f", catType, cat.getName(), cat.getDecibelsOfMeows()));
                    }
                }

                break;
            }
        }
    }
}
