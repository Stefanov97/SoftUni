import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        Map<String, List<Pokemon>> pokemons = new LinkedHashMap<>();
        while (!"Tournament".equals(line)) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemons.putIfAbsent(trainerName, new ArrayList<>());
            pokemons.get(trainerName).add(pokemon);
            line = scanner.nextLine();
        }
        pokemons.entrySet().forEach(entrty -> {
            String trainerName = entrty.getKey();
            List<Pokemon> currentPokemons = entrty.getValue();
            Trainer trainer = new Trainer(trainerName, currentPokemons);
            trainers.put(trainerName, trainer);
        });
        String secondInput = scanner.nextLine();
        while (!"End".equals(secondInput)) {
            String element = secondInput;

            trainers.entrySet().forEach(entry -> {
                Trainer trainer = entry.getValue();
                boolean hasType = false;
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equals(element)) {
                        hasType = true;
                        break;
                    }
                }
                if (hasType) {
                    trainer.addNumberOfBadges();
                } else {
                    List<Pokemon> pokemons1 = trainer.getPokemons();
                    for (int i = 0; i < pokemons1.size(); i++) {
                        Pokemon pokemon = pokemons1.get(i);
                        pokemon.remove10health();
                        if (pokemon.getHealth() <= 0) {
                            trainer.getPokemons().remove(pokemon);
                            i--;
                        }
                    }
                }
            });
            secondInput = scanner.nextLine();
        }

        trainers.entrySet().stream().sorted((f, s) -> {
            Trainer firstTrainer = f.getValue();
            Trainer secondTrainer = s.getValue();
            return secondTrainer.getNumberOfBadges() - firstTrainer.getNumberOfBadges();
        }).forEach(entry -> {
            Trainer trainer = entry.getValue();
            System.out.println(String.format("%s %d %d", trainer.getName(), trainer.getNumberOfBadges(), trainer.getPokemons().size()));
        });
    }
}
