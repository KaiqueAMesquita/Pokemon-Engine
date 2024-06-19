package pokecomp.attacks;

import pokemon.*;
import javax.swing.JOptionPane;
import pokecomp.stats.*;

public class StatsAttacks extends Attacks {
    public StatsAttacks(Types tipo, String nome, int poder, Stats status, Stats statuS) {
        super(tipo, nome, poder, status, statuS);
        poder = 0;
    }

    @Override
    public void atacando(PokemonEntity atacando, PokemonEntity atacado) {
        Stats statusAtacado = atacado.getStats();
        if (statusAtacado == Stats.NULO) {
            atacado.setStats(this.getStats());
            JOptionPane.showMessageDialog(null, "O " + atacando.getName() + " usou " + this.getName());

            JOptionPane.showMessageDialog(null, "O " + atacado.getName() + " ficou com " + this.getStats());
        } else {
            JOptionPane.showMessageDialog(null,
                    "O " + atacado.getName() + " está com " + statusAtacado + " nada aconteceu");

        }
    }
}