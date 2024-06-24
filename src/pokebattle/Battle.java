package pokebattle;

import java.util.Random;
import javax.swing.JOptionPane;
import pokemon.Pokemon;
import pokemon.PokemonEntity;
import pokecomp.attacks.Attacks;

public class Battle {
    int currencyTurn = 0;

    public void batalhaAtiva(PokemonEntity player, PokemonEntity enemy) {

        if (currencyTurn == 0) {
            JOptionPane.showMessageDialog(null, "A batalha começou! Você lançou " + player.getName());
            JOptionPane.showMessageDialog(null, "Adversário jogou " + enemy.getName());
        }
        do {
            turnPlayer(player, enemy);

        } while (true);
    }

    public void turnPlayer(PokemonEntity player, PokemonEntity enemy) {
        currencyTurn++;
        if (player.getHp() > 0) {
            do {
                String opAttack = "\n";
                for (int i = 0; i < player.getAttacks().length; i++) {
                    opAttack += i + " - " + player.getAttack(i).getName() + "\n";
                }
                int op = Integer
                        .parseInt(JOptionPane.showInputDialog(player.getName() + " - " + player.getHp() + "/"
                                + player.getMaxHp() + "\n" + enemy.getName() + " - " + enemy.getHp() + "/"
                                + enemy.getMaxHp() + "\nEscolha seu attack: " + opAttack));
                if (!player.attackIsNull(op)) {
                    Attacks attack = player.getAttack(op);
                    attack.attacking(player, enemy);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Esse attack não é válido");
                }
            } while (true);
            turnoenemy(player, enemy);

        } else {
            JOptionPane.showMessageDialog(null, "Você perdeu!");
            System.exit(0);
        }
    }

    public void turnoenemy(PokemonEntity player, PokemonEntity enemy) {
        currencyTurn++;

        if (enemy.getHp() > 0) {
            Random rand = new Random();
            int opEnemy = 0;
            Attacks atkEnemy = enemy.getAttack(opEnemy);

            do {
                opEnemy = rand.nextInt(4);
                atkEnemy = enemy.getAttack(opEnemy);
            } while (enemy.attackIsNull(opEnemy));

            if (!enemy.attackIsNull(opEnemy)) {
                JOptionPane.showMessageDialog(null,
                        "Vez do adversario \n" + enemy.getName() + ":" + enemy.getHp() + "/"
                                + enemy.getMaxHp()
                                + "\n" + player.getName() + ":" + player.getHp() + "/" + player.getMaxHp());

                atkEnemy.attacking(enemy, player);
                turnPlayer(player, enemy);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você venceu!");
            System.exit(0);
        }
    }
}