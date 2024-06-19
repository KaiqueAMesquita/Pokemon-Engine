package pokemon;

import java.util.ArrayList;
import java.util.Random;
import pokecomp.stats.*;
import pokecomp.attacks.Attacks;
import pokecomp.points.*;

public class Pokemon {
    private String pokedexName; // Nome Pokemon
    private String name; // Nome Pokemon
    private LevelGrowth levelType; // Tipo de crescimento do nível
    private int baseHp; // Pontos de Vida (HP)
    private int baseSpeed;
    private int baseAttack;
    private int baseSpdAttack;
    private int baseDefense;
    private int baseSpdDefense;

    private Types typeOne; // Tipo principal
    private Types typeTwo; // Tipo secundário
    private Attacks[] attacks;// Ataques que o pokemon pode aprender
    private int[] learningLevel = { 1, 1, 2, 5 }; // Niveis necessarios para aprender ataques

    public Pokemon(String name, int hp, int speed, int attack, int spdAttack, int defense, int spdDefense,
            Types typeOne, Types typeTwo, LevelGrowth levelType, Attacks[] attacks, int qnt) {
        this.name = name;
        this.baseHp = hp;
        this.baseSpeed = speed;
        this.baseAttack = attack;
        this.baseSpdAttack = spdAttack;
        this.baseDefense = defense;
        this.baseSpdDefense = spdDefense;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.levelType = levelType;
        this.attacks = new Attacks[qnt];
        this.attacks = attacks;
    }

    // getters e setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.baseHp;
    }

    public void setHp(int hp) {
        this.baseHp = hp;
    }

    public int getSpeed() {
        return this.baseSpeed;
    }

    public void setSpeed(int speed) {
        this.baseSpeed = speed;
    }

    public int getAttack() {
        return this.baseAttack;
    }

    public void setAttack(int attack) {
        this.baseAttack = attack;
    }

    public int getSpdAttack() {
        return this.baseSpdAttack;
    }

    public void setSpdAttack(int spdAttack) {
        this.baseSpdAttack = spdAttack;
    }

    public int getDefense() {
        return this.baseDefense;
    }

    public void setDefense(int defense) {
        this.baseDefense = defense;
    }

    public int getSpdDefense() {
        return this.baseSpdDefense;
    }

    public void setSpdDefense(int spdDefense) {
        this.baseSpdDefense = spdDefense;
    }

    public Attacks[] getAttacks() {
        return this.attacks;
    }

    public void setAttacks(Attacks[] attacks) {
        this.attacks = attacks;
    }

    public void addAttack(Attacks a) {
        if (this.attacks[attacks.length] == null) {
            this.attacks[attacks.length] = a;
        }
    }

    public int[] getLearningLevel() {
        return this.learningLevel;
    }

    public void setLearningLevel(int[] learningLevel) {
        this.learningLevel = learningLevel;
    }

    public LevelGrowth getLevelType() {
        return this.levelType;
    }

    public void setlevelType(LevelGrowth type) {
        this.levelType = type;
    }

    public Types getTypeOne() {
        return this.typeOne;
    }

    public void setTypeOne(Types t) {
        this.typeOne = t;
    }

    public Types getTypeTwo() {
        return this.typeTwo;
    }

    public void setTypeTwo(Types t) {
        this.typeTwo = t;
    }

}
