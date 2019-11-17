package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Gun> gunRepository;
    private List<Player> civilPlayers;
    private Neighbourhood neighbourhood;
    private Player mainPlayer;
    private int gunIndex;

    public ControllerImpl() {
        this.gunRepository = new GunRepository();
        this.civilPlayers = new ArrayList<>();
        this.neighbourhood = new GangNeighbourhood();
        this.mainPlayer = new MainPlayer();
        this.gunIndex = 0;
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        this.gunRepository.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Player player = this.civilPlayers.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        List<Gun> guns = new ArrayList<>(this.gunRepository.getModels());
        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }
        Gun gun = null;
        if (gunIndex < guns.size()) {
            gun = guns.get(gunIndex);
        } else {
            return GUN_QUEUE_IS_EMPTY;
        }
        if ("Vercetti".equals(name)) {
            this.mainPlayer.getGunRepository().add(gun);
            gunIndex++;
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());

        }
        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }


        player.getGunRepository().add(gun);
        gunIndex++;
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        int beforeFight = this.civilPlayers.size();
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);
        int afterFight = this.civilPlayers.size();

        boolean civilsAreNotHarmed = true;
        if (beforeFight != afterFight) {
            civilsAreNotHarmed = false;
        }
        if (civilsAreNotHarmed) {
            for (Player player : this.civilPlayers) {
                if (player.getLifePoints() != 50) {
                    civilsAreNotHarmed = false;
                    break;
                }
            }
        }
        if (this.mainPlayer.getLifePoints() == 100 && civilsAreNotHarmed) {
            return FIGHT_HOT_HAPPENED;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints())).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, beforeFight - afterFight)).append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, afterFight)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
