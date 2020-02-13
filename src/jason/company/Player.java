package jason.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int level;
    private int attack;
    private int experience;


    public Player(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.hitPoints = 100;
        this.level = 1;
        this.attack = 2;
        this.experience = 1;
    }

    @Override
    public void saveList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.name = list.get(0);
            this.weapon = list.get(1);
            this.hitPoints = list.get(2) != null ? Integer.parseInt(list.get(2)) : 100;
            this.level = list.get(3) != null ? Integer.parseInt(list.get(3)) : 1;
            this.attack = list.get(4) != null ? Integer.parseInt(list.get(4)) : 2;
            this.experience = list.get(5) != null ? Integer.parseInt(list.get(5)) : 1;
        }
    }

    @Override
    public List<String> returnList() {
        List<String> traits = new ArrayList<String>();

        if (hitPoints > 0) {
            traits.add(0, "" + name);
            traits.add(1, "" + weapon);
            traits.add(2, "" + hitPoints);
            traits.add(3, "" + level);
            traits.add(4, "" + attack);
            traits.add(5, "" + experience);
        } else {
            System.out.println("Player dead");
            return null;
        }

        return traits;
    }

    public String heal(int health) {
        hitPoints += health;
        return health + " health gained";
    }

    @Override
    public void getDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints <= 0) {
            System.out.println("Player Dead");
            return;
        }
        System.out.println(damage + " damage received. " + hitPoints + " hit points left.");
    }

    @Override
    public int attack() {
        int attack = this.attack * ((int)(Math.random() * ((this.level - 0) + 1)));
        this.experience += attack;
        if (this.experience % 50 == 0) {
            this.level += 1;
            this.attack += 1;
            this.hitPoints += 5;
            System.out.println("Level Up!");
        }
        return attack;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Player is " + name + "\n"
                + "Weapon is " + weapon + "\n"
                + "Hit points are " + hitPoints + "\n"
                + "Level is " + level + "\n"
                + "Attack is " + attack + "\n"
                + "Experience is " + experience + "\n";
    }
}
