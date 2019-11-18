package repositories;

import models.cakes.BaseCake;
import models.cakes.childCakes.ChildCake;
import models.cakes.specialCakes.SpecialCake;
import models.cakes.standardCakes.StandardCake;
import models.cakes.weddingCakes.WeddingCake;

import repositories.interfaces.CakeCatalog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CakeCatalogImpl implements CakeCatalog {
    private List<StandardCake> standardCakes;
    private List<WeddingCake> weddingCakes;
    private List<SpecialCake> specialCakes;
    private List<ChildCake> childCakes;

    public CakeCatalogImpl(){
        this.standardCakes = new ArrayList<>();
        this.weddingCakes = new ArrayList<>();
        this.specialCakes = new ArrayList<>();
        this.childCakes = new ArrayList<>();
    }
    @Override
    public void addStandardCake(StandardCake cake) {
        this.standardCakes.add(cake);
    }

    @Override
    public void addWeddingCake(WeddingCake cake) {
        this.weddingCakes.add(cake);
    }

    @Override
    public void addSpecialCake(SpecialCake cake) {
        this.specialCakes.add(cake);
    }

    @Override
    public void addChildCake(ChildCake cake) {
        this.childCakes.add(cake);
    }

    @Override
    public boolean removeStandardCake(String name) {
        StandardCake cakeToRemove = this.standardCakes.stream().filter(cake -> cake.getName().equals(name)).findFirst().orElse(null);
       return this.standardCakes.remove(cakeToRemove);

    }

    @Override
    public boolean removeWeddingCake(String name) {
        WeddingCake cakeToRemove = this.weddingCakes.stream().filter(cake -> cake.getName().equals(name)).findFirst().orElse(null);
        return this.weddingCakes.remove(cakeToRemove);
    }

    @Override
    public boolean removeSpecialCake(String name) {
        SpecialCake cakeToRemove = this.specialCakes.stream().filter(cake -> cake.getName().equals(name)).findFirst().orElse(null);
        return this.specialCakes.remove(cakeToRemove);
    }

    @Override
    public boolean removeChildCake(String name) {
        ChildCake cakeToRemove = this.childCakes.stream().filter(cake -> cake.getName().equals(name)).findFirst().orElse(null);
        return this.childCakes.remove(cakeToRemove);
    }


    @Override
    public List<StandardCake> getStandardCakes() {
      this.standardCakes= this.standardCakes.stream().sorted((f,s)-> Double.compare(s.getPrice(),f.getPrice())).collect(Collectors.toList());
        return this.standardCakes;
    }

    @Override
    public List<WeddingCake> getWeddingCakes() {
       this.weddingCakes = this.weddingCakes.stream().sorted(Comparator.comparingInt(BaseCake::getCountOfPieces)).collect(Collectors.toList());
        return this.weddingCakes;
    }

    @Override
    public List<SpecialCake> getSpecialCakes() {
       this.specialCakes = this.specialCakes.stream().sorted((f,s)-> Double.compare(s.getPrice(),f.getPrice())).collect(Collectors.toList());
        return this.specialCakes;
    }

    @Override
    public List<ChildCake> getChildCakes() {
     this.childCakes =  this.childCakes.stream().sorted(Comparator.comparingInt(BaseCake::getCountOfPieces)).collect(Collectors.toList());
        return this.childCakes;
    }
}
