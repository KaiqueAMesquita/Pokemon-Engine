package pokecomp.move;

import pokemon.Types;

import java.util.Random;
import pokecomp.status.*;
import javax.swing.JOptionPane;

import pokebattle.BattleEfetiveness;
import pokecomp.status.StatusType;
import pokemon.PokemonEntity;

public abstract class Move {

    public BattleEfetiveness bt;

    protected int id;
    protected String name;
    protected Types type;
    protected int pp;
    protected int priority;
    protected int acurracy;
    protected int power;
    protected Status effect;
    protected int effectChance;
    protected Function function;
    protected int[] individualValue = new int[6];
    // [0]hits, [1]hp,[2]ataque,[3]spdAtaque,[4]defense,[5]spdDefense,[6]speed

    public Move(int id, String name, Types type, int pp, int priority, int acurracy, int power, Status effect,
            int effectChance) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pp = pp;
        this.priority = priority;
        this.acurracy = acurracy;
        this.power = power;
        this.effect = effect;
        this.effectChance = effectChance;
        this.individualValue[0] = 1;
        this.function = function;
    }

    public abstract int calculateDamage(PokemonEntity attacker, PokemonEntity target);

    public abstract void attacking(PokemonEntity attacker, PokemonEntity target);

    public String getName() {
        return name;
    }

    public boolean calcChance() {
        Random rand = new Random();
        double chance = rand.nextDouble() * 100;
        return chance <= this.acurracy;
    }

    public int measureEffectiveness(PokemonEntity target) {
        double secEffectiveness = -1;
        double priEffectiveness = bt.getEffectiveness(this.type, target.getPokemon().getTypeOne());
        if (target.getPokemon().getTypeTwo() != null) {
            secEffectiveness = bt.getEffectiveness(this.type, target.getPokemon().getTypeTwo());
        }
        if (secEffectiveness > -1) {
            if (priEffectiveness == 2 && secEffectiveness == 2) {
                return 8;

            } else {
                return (int) (priEffectiveness * secEffectiveness);
            }
        } else {
            return (int) priEffectiveness;

        }
    }

    public boolean calcEffectChance() {
        Random rand = new Random();
        double chance = rand.nextDouble() * 100;
        return chance <= this.effectChance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getAcurracy() {
        return acurracy;
    }

    public void setAcurracy(int acurracy) {
        this.acurracy = acurracy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public int getIndividualValue(int i) {
        return this.individualValue[i];

    }

    public int[] getIndividualValue() {
        return this.individualValue;

    }

    public void setIndividualValue(int i, int value) {
        this.individualValue[i] = value;
    }
}
