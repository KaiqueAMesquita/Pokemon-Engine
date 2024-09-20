package pokecomp.status;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import interfaces.EffectAct;
import pokemon.PokemonEntity;

public class Status {
    private String name;
    private int min_duration;
    private int max_duration;
    private EffectAct act;
    private int count;
    private StatusFactory sf;

    public Status(String name, int min_duration, int max_duration, EffectAct act) {
        this.name = name;
        this.min_duration = min_duration;
        this.max_duration = max_duration;
        this.act = act;
        this.count = 0;
    }

    public void apply(PokemonEntity target) {
        target.setStatus(this);
        JOptionPane.showMessageDialog(null, "O pokémon está com " + this.name);
    }

    public Status applyStatus(Status status, PokemonEntity pkm) {
        Status s = status;
        s.apply(pkm);
        return s;
    }

    // get
    public int getMaxDuration() {
        return max_duration;
    }

    public int getMinDuration() {
        return min_duration;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }

    // set
    public void setDuration(int duration) {
        this.max_duration = duration;
    }

    public void setMinDuration(int duration) {
        this.min_duration = duration;
    }

    public Status getStatus(int i) {
        return sf.getStatus(i);

    }

    public void Act(PokemonEntity pkm) {
        if (this.getCount() <= this.getMaxDuration()) {
            act.effectAct(pkm);
            this.addCount();
            if (this.getCount() >= min_duration) {
                Random rand = new Random();
                int chance = rand.nextInt(100);
                if (chance <= 20) {
                    pkm.setStatus(null);
                }
            }
        } else {
            pkm.setStatus(null);
        }
    }

}
