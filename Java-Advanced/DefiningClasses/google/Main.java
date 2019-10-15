import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Company> companyMap = new LinkedHashMap<>();
        Map<String, Car> carsMap = new LinkedHashMap<>();
        Map<String, Person> peopleMap = new LinkedHashMap<>();
        Map<String, List<Pokemon>> pokemonList = new LinkedHashMap<>();
        Map<String, List<Parents>> parentsList = new LinkedHashMap<>();
        Map<String, List<Children>> childrenList = new LinkedHashMap<>();
        while (!"End".equals(line)) {

            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String comparable = tokens[1];
            switch (comparable) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    companyMap.put(name, company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    pokemonList.putIfAbsent(name, new ArrayList<>());
                    pokemonList.get(name).add(pokemon);
                    break;

                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parents parents = new Parents(parentName, parentBirthday);
                    parentsList.putIfAbsent(name, new ArrayList<>());
                    parentsList.get(name).add(parents);
                    break;

                case "children":
                    String childrenName = tokens[2];
                    String childrenBirthday = tokens[3];
                    Children children = new Children(childrenName, childrenBirthday);
                    childrenList.putIfAbsent(name, new ArrayList<>());
                    childrenList.get(name).add(children);
                    break;
                case "car":
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    Car car = new Car(carModel, carSpeed);
                    carsMap.put(name, car);
                    break;
            }
            line = scanner.nextLine();
        }
        String printName = scanner.nextLine();
        Company company = null;
        List<Pokemon> pokemon = null;
        List<Parents> parents = null;
        List<Children> children = null;
        Car car = null;
        if (companyMap.containsKey(printName)) {
            company = companyMap.get(printName);
        } else {
            company = new Company("", "", 0);
        }

        if (carsMap.containsKey(printName)) {

            car = carsMap.get(printName);


        } else {
            car = new Car("", "");
        }

        if (pokemonList.containsKey(printName)) {

            List<Pokemon> pokemons = pokemonList.get(printName);
            pokemon = pokemons;

        } else {
            pokemon = new ArrayList<>();
        }

        if (parentsList.containsKey(printName)) {

            parents = parentsList.get(printName);


        } else {
            parents = new ArrayList<>();
        }

        if (childrenList.containsKey(printName)) {

            children = childrenList.get(printName);


        } else {
            children = new ArrayList<>();
        }

        Person person = new Person(printName, company, pokemon, parents, children, car);
        System.out.println(person.getName());
        System.out.println("Company:");
        if (!person.getCompany().getCompanyName().equals("")) {
            System.out.println(String.format("%s %s %.2f", person.getCompany().getCompanyName(), person.getCompany().getDepartment(), person.getCompany().getSalary()));
        }
        System.out.println("Car:");
        if (!person.getCar().getCarModel().equals("")) {
            System.out.println(String.format("%s %s", person.getCar().getCarModel(), person.getCar().getCarSpeed()));

        }
        System.out.println("Pokemon:");
        if (person.getPokemon().size() > 0) {
            for (Pokemon p : person.getPokemon()) {
                System.out.println(String.format("%s %s", p.getPokemonName(), p.getPokemonType()));
            }

        }
        System.out.println("Parents:");
        if (person.getParents().size() > 0) {
            for (Parents parent : person.getParents()) {
                System.out.println(String.format("%s %s", parent.getParentName(), parent.getParentBirthday()));
            }

        }
        System.out.println("Children:");
        if (person.getChildren().size() > 0) {
            for (Children child : person.getChildren()) {
                System.out.println(String.format("%s %s", child.getChildName(), child.getChildBirthday()));
            }

        }
    }
}
