package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        List<Gun> mainPlayerGuns = new ArrayList<>(mainPlayer.getGunRepository().getModels());
        List<Player> victims = new ArrayList<>(civilPlayers);
        boolean areThereCivilPlayersAlive = victims.size() > 0;
        mainPlayerAttack(mainPlayerGuns, areThereCivilPlayersAlive, victims, civilPlayers);
        areThereCivilPlayersAlive = !victims.isEmpty();
        if (areThereCivilPlayersAlive) {
            civilPlayersAttack(victims, mainPlayer);
        }
    }

    private void civilPlayersAttack(List<Player> victims, Player mainPlayer) {
        for (Player victim : victims) {
            List<Gun> victimGuns = new ArrayList<>(victim.getGunRepository().getModels());
            for (Gun gun : victimGuns) {
                while (gun.canFire() && mainPlayer.isAlive()) {
                    int damage = gun.fire();
                    mainPlayer.takeLifePoints(damage);
                }
            }
        }
    }

    private void mainPlayerAttack(List<Gun> mainPlayerGuns, boolean areThereCivilPlayersAlive, List<Player> victims, Collection<Player> civilPlayers) {
        for (Gun gun : mainPlayerGuns) {
            while (gun.canFire() && areThereCivilPlayersAlive) {
                int damage = gun.fire();
                Player victim = victims.get(0);
                victim.takeLifePoints(damage);
                if (!victim.isAlive()) {
                    victims.remove(0);
                    civilPlayers.remove(victim);
                    if (victims.isEmpty()) {
                        areThereCivilPlayersAlive = false;
                    }
                }
            }
        }
    }
}
