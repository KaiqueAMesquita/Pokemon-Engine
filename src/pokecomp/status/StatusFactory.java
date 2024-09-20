package pokecomp.status;

import java.util.Random;

import javax.swing.JOptionPane;

import pokemon.PokemonEntity;

public class StatusFactory {
    public PokemonEntity pkm;
    public Status[] status = new Status[7];

    public StatusFactory() {
        pokemonStatus();
    }

    public Status getStatus(int i) {
        return status[i];
    }

    public void pokemonStatus() {
        status[1] = POISON;
        status[2] = BURN;
        status[3] = FREEZE;
        status[4] = SLEEP;
        status[5] = PARALYZE;
        status[6] = CONFUSION;
        status[7] = FLINCH;

    }

    public static final Status POISON = new Status("Envenenado", -1, -1, (pkm) -> {
        int damage = pkm.getMaxHp() / 16;
        pkm.setHp(pkm.getHp() - damage);
        JOptionPane.showMessageDialog(null,
                pkm.getName() + " Sofreu dano de envenenamento: " + pkm.getMaxHp() + "/" + pkm.getHp());
    });

    public static final Status BURN = new Status("Queimado", -1, -1, (pkm) -> {
        int damage = pkm.getMaxHp() / 8;
        pkm.setHp(pkm.getHp() - damage);
        JOptionPane.showMessageDialog(null,
                pkm.getName() + " Sofreu dano de queimadura: " + pkm.getMaxHp() + "/" + pkm.getHp());
    });;

    public static final Status FREEZE = new Status("Congelado", 3, 4, (pkm) -> {
        JOptionPane.showMessageDialog(null,
                pkm.getName() + " Está congelado: " + pkm.getMaxHp() + "/" + pkm.getHp());

    });

    public static final Status SLEEP = new Status("Sono", 1, 4, (pkm) -> {
        JOptionPane.showMessageDialog(null,
                pkm.getName() + " Está dormindo: " + pkm.getMaxHp() + "/" + pkm.getHp());
    });

    public static final Status PARALYZE = new Status("Paralisado", -1, -1, (pkm) -> {
        Random rand = new Random();
        if (rand.nextInt(100) < 25) {
            JOptionPane.showMessageDialog(null,
                    pkm.getName() + " Está com paralisia: " + pkm.getMaxHp() + "/" + pkm.getHp());
        }
    });

    public static final Status CONFUSION = new Status("Confuso", 2, 5, (pkm) -> {
        Random rand = new Random();
        if (rand.nextInt(100) < 50) {
            double randomValue = 0.85 + (1.00 - 0.85) * rand.nextDouble();
            double calcDamage = (((2 * pkm.getLevel() / 5 + 2) * 40
                    * (pkm.getAttack() / pkm.getDefense()) + 2) / 50) * 1 * 1 * 1 * 1
                    * randomValue * 1 * 1 * 1;
            int damage = (int) calcDamage;
            pkm.setHp(pkm.getHp() - damage);
            JOptionPane.showMessageDialog(null,
                    pkm.getName() + " Está confuso e se atacou: " + pkm.getMaxHp() + "/" + pkm.getHp());

        }
    });

    public static final Status FLINCH = new Status("Recuou", 1, 1, (pkm) -> {
        JOptionPane.showMessageDialog(null,
                pkm.getName() + " Está se contorcendo e não consegue atacar!: " + pkm.getMaxHp() + "/" + pkm.getHp());

    });

}
