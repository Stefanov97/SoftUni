package greedyTimes;

import java.util.LinkedHashSet;

public class Bag {
    private long capacity;
    private LinkedHashSet<Gold> gold;
    private LinkedHashSet<Cash> cash;
    private LinkedHashSet<Gem> gems;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gold = new LinkedHashSet<>();
        this.cash = new LinkedHashSet<>();
        this.gems = new LinkedHashSet<>();

    }

    public long getCapacity() {
        return this.capacity;
    }


    public void addGold(Gold gold) {
        this.gold.add(gold);
        this.capacity -= gold.getQuantity();

    }

    public void addGems(Gem gem) {
        long goldQuantity = getGoldSum();

        long gemsQuantity = gem.getQuantity();
        boolean thisGemExsist = false;
        for (Gem currentGem : this.gems) {
            gemsQuantity += currentGem.getQuantity();
            if (currentGem.getName().equals(gem.getName())) {
                thisGemExsist = true;
            }
        }
        if (goldQuantity >= gemsQuantity) {
            if (thisGemExsist) {
                for (Gem currentGem : this.gems) {
                    if (currentGem.getName().equals(gem.getName())) {
                        currentGem.addQuantity(gem.getQuantity());
                        break;
                    }
                }
            } else {
                this.gems.add(gem);
            }

            this.capacity -= gem.getQuantity();
        }
    }

    public void addCash(Cash cash) {
        long gemsQuantity = getGemsSum();

        boolean thisValueExsist = false;
        long cashQuantity = cash.getQuantity();
        for (Cash currentCash : this.cash) {
            if (currentCash.getName().equals(cash.getName())) {
                thisValueExsist = true;
            }
            cashQuantity += currentCash.getQuantity();
        }
        if (gemsQuantity >= cashQuantity) {

            if (thisValueExsist) {
                for (Cash currentCash : this.cash) {
                    if (currentCash.getName().equals(cash.getName())) {
                        currentCash.addQuantity(cash.getQuantity());
                        break;
                    }
                }
            } else {
                this.cash.add(cash);
            }
            this.capacity -= cash.getQuantity();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        long goldSum = getGoldSum();
        if (!this.gold.isEmpty()) {
            sb.append(String.format("<Gold> $%d", goldSum)).append(System.lineSeparator());
            sb.append(String.format("##Gold - %d", goldSum)).append(System.lineSeparator());
        }
        if (!this.gems.isEmpty()) {
            long gemsSum = getGemsSum();
            sb.append(String.format("<Gem> $%d", gemsSum)).append(System.lineSeparator());
            this.gems.stream().sorted((f, s) -> {
                int result = s.getName().compareTo(f.getName());
                if (result == 0) {
                    result = Long.compare(f.getQuantity(), s.getQuantity());
                }
                return result;
            }).forEach(gem -> {
                sb.append(String.format("##%s - %d", gem.getName(), gem.getQuantity())).append(System.lineSeparator());
            });
        }

        if (!this.cash.isEmpty()) {
            long cashSum = getCashSum();
            sb.append(String.format("<Cash> $%d", cashSum)).append(System.lineSeparator());
            this.cash.stream().sorted((f, s) -> {
                int result = s.getName().compareTo(f.getName());
                if (result == 0) {
                    result = Long.compare(f.getQuantity(), s.getQuantity());
                }
                return result;
            }).forEach(cash -> {
                sb.append(String.format("##%s - %d", cash.getName(), cash.getQuantity())).append(System.lineSeparator());
            });
        }

        return sb.toString().trim();
    }

    private long getCashSum() {
        long cashSum = 0;
        for (Cash currentCash : this.cash) {
            cashSum += currentCash.getQuantity();
        }
        return cashSum;

    }

    private long getGemsSum() {
        long gemsSum = 0;
        for (Gem gem : this.gems) {
            gemsSum += gem.getQuantity();
        }
        return gemsSum;
    }

    private long getGoldSum() {
        long goldSum = 0;
        for (Gold currentGold : this.gold) {
            goldSum += currentGold.getQuantity();
        }
        return goldSum;
    }
}
