package pokecenter;

import java.util.Optional;

enum Type {
    NORMAL,
    FIRE,
    WATER,
    GRASS,
    BUG,
    PSYCHIC,
    FLYING,
    FAIRY,
    POISON,
    GROUND,
    DARK,
    ELECTRIC,
    ICE,
    STEEL,
    FIGHTING,
    ROCK,
    GHOST,
    DRAGON
}

public class Pokemon {
    int id;
    String name;
    Type type1;
    Optional<Type> type2;
    int total;
    int hp;
    int attack;
    int defense;
    int sp_attack;
    int sp_defense;
    int speed;
    int generation;
    Boolean legendary;

    public Pokemon(int id, String name, Type type1, Optional<Type> type2, int total, int hp, int attack, int defense, int sp_attack, int sp_defense, int speed, int generation, Boolean legendary) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.sp_attack = sp_attack;
        this.sp_defense = sp_defense;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    @Override
    public String toString() {
        return id + "," +
                name + "," +
                type1 + "," +
                (type2.isEmpty() ? "" : type2.get()) + "," +
                total + "," +
                hp + "," +
                attack + "," +
                defense + "," +
                sp_attack + "," +
                sp_defense + "," +
                speed + "," +
                generation + "," +
                legendary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1.toString().substring(0, 1).toUpperCase() + type1.toString().toLowerCase().substring(1);
    }

    public String getType2() {
        if (type2.isEmpty())
            return "";
        return type2.get().toString().substring(0, 1).toUpperCase() + type2.get().toString().toLowerCase().substring(1);
    }

    public int getTotal() {
        return total;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSp_attack() {
        return sp_attack;
    }

    public int getSp_defense() {
        return sp_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGeneration() {
        return generation;
    }

    public Boolean getLegendary() {
        return legendary;
    }
}
