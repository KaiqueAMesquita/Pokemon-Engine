package pokecomp.attacks;

import pokemon.*;
import java.util.Random;

import javax.swing.JOptionPane;

import pokebattle.BattleEffet;
import pokecomp.stats.Stats;

public class Attacks {
    private Types tipo;
    private String name;
    public BattleEffet tb;
    private int poder;
    private Stats status;
    private Stats statuS;

    public Attacks(Types tipo, String name, int poder, Stats status, Stats statuS) {
        this.tipo = tipo;
        this.name = name;
        this.poder = poder;
        this.status = status;
        this.statuS = statuS;
    }

    public int medirEfetividade(PokemonEntity atacado) {
        double efetivS = -1;
        double efetivP = tb.getEfetividade(this.tipo, atacado.getPokemon().getTypeOne());
        if (atacado.getPokemon().getTypeTwo() != null) {
            efetivS = tb.getEfetividade(this.tipo, atacado.getPokemon().getTypeTwo());
        }
        if (efetivS > -1) {
            return (int) (efetivP * efetivS);
        } else {
            return (int) efetivP;

        }
    }

    // get e set
    public Types getTipo() {
        return tipo;
    }

    public void setTipo(Types tipo) {
        this.tipo = tipo;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public Stats getStats() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Stats getStatuS() {
        return statuS;
    }

    public void atacando(PokemonEntity atacando, PokemonEntity atacado) {
        int damage = (int) (((2 * atacando.getLevel() / 5 + 2) * this.poder
                * (atacando.getAttack() / atacado.getDefense()) + 2) / 50) * medirEfetividade(atacado);
        if (damage <= 1) {
            damage = 1;
        }
        if (statuS == Stats.NULO) {
            atacado.setHp(atacado.getHp() - damage);
            JOptionPane.showMessageDialog(null, "O " + atacando.getName() + " usou " + this.getName() + "!");
        } else {
            atacado.setHp(atacado.getHp() - damage);
            Random rand = new Random();
            JOptionPane.showMessageDialog(null, "O " + atacando.getName() + " usou " + this.getName() + "!");
            if (rand.nextDouble() < 0.2) {
                atacado.setStats(this.statuS);
                JOptionPane.showMessageDialog(null, "O " + atacado.getName() + " ficou com " + this.getStats());

            }

        }
    }
}