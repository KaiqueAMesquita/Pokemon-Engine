package pokecomp.move;

import java.util.Random;

import javax.swing.JOptionPane;

import pokemon.PokemonEntity;

public class FunctionMove {

    public void applyInitFunction(Function func, Move move) {
        switch (func) {
            case TWO_HITS:
                move.setIndividualValue(0, 2);
                break;
            case MAGNETUTIDE:
                Random r = new Random();
                int rand = r.nextInt(10) + 1;
                move.setPower(10 * rand);
                break;
            default:
                break;
        }

    }

    public void applyStatusFunction(PokemonEntity target, Function func, Move move) {
        switch (func) {
            case STATS_UP:
                for (int i = 2; i < move.getIndividualValue().length; i++) {
                    if (move.getIndividualValue(i) > 0) {
                        editStatsPokemon(1.5, i, target);
                        JOptionPane.showMessageDialog(null, "Pokémon teve seu status {" + i + "} aumentado!");
                    }
                }
                break;
            case STATS_DOWN:
                for (int i = 2; i < move.getIndividualValue().length; i++) {
                    if (move.getIndividualValue(i) > 0) {
                        editStatsPokemon(0.75, i, target);
                        JOptionPane.showMessageDialog(null, "Pokémon teve seu status {" + i + "} diminuido!");
                    }
                }
                break;
            default:

                break;

        }
    }

    public void editStatsPokemon(double value, int i, PokemonEntity pkm) {
        int stat;
        switch (i) {
            case 2:
                stat = (int) (pkm.getAttack() * value);
                pkm.setAttack(stat);
                break;
            case 3:
                stat = (int) (pkm.getSpdAttack() * value);
                pkm.setSpdAttack(stat);
                break;
            case 4:
                stat = (int) (pkm.getDefense() * value);
                pkm.setDefense(stat);
                break;
            case 5:
                stat = (int) (pkm.getSpdDefense() * value);
                pkm.setSpdDefense(stat);
                break;
            case 6:
                stat = (int) (pkm.getSpeed() * value);
                pkm.setSpeed(stat);
                break;

        }

    }

}
