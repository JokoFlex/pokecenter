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
    DRAGON,
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

    public Pokemon(int id, String name, Type type1, Optional<Type> type2, int total, int hp, int attack, int defense, int sp_attack, int sp_defense, int speed) {
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
                speed;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public void setType2(Optional<Type> type2) {
        this.type2 = type2;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSp_attack(int sp_attack) {
        this.sp_attack = sp_attack;
    }

    public void setSp_defense(int sp_defense) {
        this.sp_defense = sp_defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

