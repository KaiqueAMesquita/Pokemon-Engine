package pokecomp.move;

import java.util.Random;

import javax.swing.JOptionPane;

import pokemon.PokemonEntity;
import pokemon.Types;
import pokecomp.status.*;

public class DamageMove extends Move {
    private FunctionMove fm;

    private Function function;
    private String category;

    public DamageMove(int id, String name, Types type, int pp, int priority, int acurracy, int power, Status effect,
            int effectChance, Function function, String category) {
        super(id, name, type, pp, priority, acurracy, power, effect, effectChance);
        this.category = category;
        this.function = function;
    }

    @Override
    public int calculateDamage(PokemonEntity attacker, PokemonEntity target) {
        Random rand = new Random();
        double calcDamage = 0;
        double randomValue = 0.85 + (1.00 - 0.85) * rand.nextDouble();
        double stab = 1;
        int statsDamage = 1;
        if (this.getType() == attacker.getPokemon().getTypeOne()
                || this.getType() == attacker.getPokemon().getTypeTwo()) {
            stab = 1.5;
        }

        calcDamage = (((2 * attacker.getLevel() / 5 + 2) * this.power
                * (attacker.getSpdAttack() / target.getSpdDefense()) + 2) / 50) * 1 * 1 * 1 * 1
                * randomValue * stab * measureEffectiveness(target) * statsDamage * 1;

        int damage = (int) calcDamage;

        if (damage <= 1) {
            damage = 1;
        }
        return damage;
    }

    @Override
    public void attacking(PokemonEntity attacker, PokemonEntity target) {
        boolean chance = this.calcChance();
        if (chance) {
            if (function == null) {
                fm.applyInitFunction(function, this);
            }
            int hits = this.getIndividualValue(0);
            for (int i = 0; i < hits; i++) {
                JOptionPane.showMessageDialog(null, "O " + attacker.getName() + " usou " + this.name + "!");
                int damage = calculateDamage(attacker, target);
                target.setHp(target.getHp() - damage);
                JOptionPane.showMessageDialog(null,
                        "O " + target.getName() + " sofreu dano " + target.getHp() + "/" + target.getMaxHp() + "!");

                if (effect == null) {
                    boolean eChance = calcEffectChance();
                    if (eChance) {
                        effect.apply(target);
                    }
                }
                if (function != null) {
                    if (function == Function.STATS_UP) {
                        fm.applyStatusFunction(attacker, function, this);
                    } else {
                        fm.applyStatusFunction(target, function, this);
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Ataque errou!");
        }
    }

}