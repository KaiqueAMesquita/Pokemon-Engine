package pokebattle;

import java.util.Random;
import javax.swing.JOptionPane;
import pokemon.Pokemon;
import pokemon.PokemonEntity;
import pokecomp.attacks.Attacks;

public class Battle {
    int turnoAtual = 0;

    public void batalhaAtiva(PokemonEntity jogador, PokemonEntity inimigo) {

        if (turnoAtual == 0) {
            JOptionPane.showMessageDialog(null, "A batalha começou! Você lançou " + jogador.getName());
            JOptionPane.showMessageDialog(null, "Adversário jogou " + inimigo.getName());
        }
        do {
            turnoJogador(jogador, inimigo);

        } while (true);
    }

    public void turnoJogador(PokemonEntity jogador, PokemonEntity inimigo) {
        turnoAtual++;
        if (jogador.getHp() > 0) {
            do {
                String opAtaque = "\n";
                for (int i = 0; i < jogador.getAttacks().length; i++) {
                    opAtaque += i + " - " + jogador.getAttack(i).getName() + "\n";
                }
                int op = Integer
                        .parseInt(JOptionPane.showInputDialog(jogador.getName() + " - " + jogador.getHp() + "/"
                                + jogador.getMaxHp() + "\n" + inimigo.getName() + " - " + inimigo.getHp() + "/"
                                + inimigo.getMaxHp() + "\nEscolha seu ataque: " + opAtaque));
                if (!jogador.attackIsNull(op)) {
                    Attacks ataque = jogador.getAttack(op);
                    ataque.atacando(jogador, inimigo);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Esse ataque não é válido");
                }
            } while (true);
            turnoInimigo(jogador, inimigo);

        } else {
            JOptionPane.showMessageDialog(null, "Você perdeu!");
            System.exit(0);
        }
    }

    public void turnoInimigo(PokemonEntity jogador, PokemonEntity inimigo) {
        turnoAtual++;

        if (inimigo.getHp() > 0) {
            Random rand = new Random();
            int opEnemy = 0;
            Attacks atqInimigo = inimigo.getAttack(opEnemy);

            do {
                opEnemy = rand.nextInt(4);
                atqInimigo = inimigo.getAttack(opEnemy);
            } while (inimigo.attackIsNull(opEnemy));

            if (!inimigo.attackIsNull(opEnemy)) {
                JOptionPane.showMessageDialog(null,
                        "Vez do adversario \n" + inimigo.getName() + ":" + inimigo.getHp() + "/"
                                + inimigo.getMaxHp()
                                + "\n" + jogador.getName() + ":" + jogador.getHp() + "/" + jogador.getMaxHp());

                atqInimigo.atacando(inimigo, jogador);
                turnoJogador(jogador, inimigo);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Você venceu!");
            System.exit(0);
        }
    }
}