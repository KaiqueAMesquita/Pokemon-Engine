package pokecomp.attacks;

import java.util.ArrayList;
import pokecomp.stats.*;
import pokemon.*;;

public class AttackList {
    public static ArrayList<Attacks> ataquesLista = new ArrayList<>();
    Attacks a1 = new Attacks(Types.NORMAL, "Tackle", 40, Stats.NULO, Stats.NULO);
    Attacks a2 = new Attacks(Types.FIRE, "Ember", 40, Stats.QUEIMADO, Stats.QUEIMADO);
    Attacks a3 = new Attacks(Types.WATER, "Water Gun", 40, Stats.NULO, Stats.NULO);
    StatsAttacks a4 = new StatsAttacks(Types.ELETRIC, "Thunder Have", 0, Stats.PARALISIA, Stats.NULO);

    public AttackList() {
        ataquesLista.add(a1);
        ataquesLista.add(a2);
        ataquesLista.add(a3);
        ataquesLista.add(a4);
    }

}