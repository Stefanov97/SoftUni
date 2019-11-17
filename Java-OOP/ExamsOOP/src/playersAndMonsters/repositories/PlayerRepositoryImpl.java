package playersAndMonsters.repositories;

import playersAndMonsters.models.players.interfaces.Player;
import playersAndMonsters.repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        List<Player> filtered = this.players.stream().filter(player1 -> player1.getUsername().equals(player.getUsername())).collect(Collectors.toList());
        if (!filtered.isEmpty()) {
            throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
        }
        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        return this.players.remove(player);
    }

    @Override
    public Player find(String name) {
        Player player = null;
        player = this.players.stream().filter(player1 -> player1.getUsername().equals(name)).findFirst().orElse(null);
        return player;
    }
}
