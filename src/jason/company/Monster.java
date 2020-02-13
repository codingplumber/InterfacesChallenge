package jason.company;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {
    private String name;
    private String race;
    private int attack;
    private int hitPoints;

    public Monster(String name, String race, int attack, int hitPoints) {
        this.name = name;
        this.race = race;
        this.attack = attack;
        this.hitPoints = hitPoints;
    }

    @Override
    public void saveList(List<String> list) {
        this.name = list.get(0);
        this.race = list.get(1);
        this.attack = Integer.parseInt(list.get(2));
        this.hitPoints = Integer.parseInt(list.get(3));
    }

    // make sure these are overridden so the call doesn't fall back to this base class and not the interface as we intend
    @Override
    public List<String> returnList() {
        List<String> traits = new ArrayList<String>();

        if (hitPoints > 0) {
            traits.add(name);
            traits.add(race);
            traits.add("" + attack);
            traits.add("" + hitPoints);
        } else {
            System.out.println(race + " dead");
        }

        return traits;
    }

    @Override
    public void getDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints <= 0) {
            System.out.println(race + " dead");
            return;
        }
        System.out.println(damage + " damage inflicted on " + race);
    }

    @Override
    public int attack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Name is " + name + "\n"
                + "Race is " + race + "\n"
                + "Attack is " + attack + "\n"
                + "Hit points are " + hitPoints + "\n";
    }

    public String getName() {
        return name;
    }
}
