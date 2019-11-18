package repositories.interfaces;

import models.cakes.childCakes.ChildCake;
import models.cakes.specialCakes.SpecialCake;
import models.cakes.standardCakes.StandardCake;
import models.cakes.weddingCakes.WeddingCake;

import java.util.List;

public interface CakeCatalog {
    void addStandardCake(StandardCake cake);
    void addWeddingCake(WeddingCake cake);
    void addSpecialCake(SpecialCake cake);
    void addChildCake(ChildCake cake);
    boolean removeStandardCake(String name);
    boolean removeWeddingCake(String name);
    boolean removeSpecialCake(String name);
    boolean removeChildCake(String name);

    List<StandardCake> getStandardCakes();
    List<WeddingCake> getWeddingCakes();
    List<SpecialCake> getSpecialCakes();
    List<ChildCake> getChildCakes();

}
