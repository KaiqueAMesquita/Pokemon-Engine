package pokedex;

import java.util.ArrayList;
import pokemon.*;
import pokecomp.attacks.*;

public class Pokedex {
    public AttackList atkl = new AttackList();
    public static GenerateDex generate = new GenerateDex();
    public Pokemon[] generates = this.pokemonsEntrada(generate.pokemonsArray);
    public ArrayList<Pokemon> pokemonLista = new ArrayList<>();

    public Pokedex() {
        for (int i = 0; i < generates.length; i++) {
            pokemonLista.add(generates[i]);
        }
    }

    public Attacks[] preencherAtaques(ArrayList<Attacks> atqs) {
        Attacks[] ataques = new Attacks[atqs.size()];
        for (int i = 0; i < atqs.size(); i++) {
            ataques[i] = atqs.get(i);
        }
        return ataques;
    }

    public Pokemon[] pokemonsEntrada(ArrayList<Pokemon> pkms) {
        Pokemon[] pokemons = new Pokemon[pkms.size()];
        for (int i = 0; i < pkms.size(); i++) {
            pokemons[i] = pkms.get(i);
        }
        return pokemons;
    }

}