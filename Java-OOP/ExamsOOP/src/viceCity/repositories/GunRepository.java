package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GunRepository implements Repository<Gun> {
    private List<Gun> guns;
    public GunRepository(){
        this.guns = new ArrayList<>();
    }
    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(this.guns);
    }

    @Override
    public void add(Gun gun) {
        List<Gun> filtered = this.guns.stream().filter(g -> g.getName().equals(gun.getName())).collect(Collectors.toList());
        if(filtered.isEmpty()){
            this.guns.add(gun);
        }
    }

    @Override
    public boolean remove(Gun gun) {
        return this.guns.remove(gun);
    }

    @Override
    public Gun find(String name) {
        return this.guns.stream().filter(g->g.getName().equals(name)).findFirst().orElse(null);
    }
}
