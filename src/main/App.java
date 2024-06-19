package main;

import java.util.Random;
import pokebattle.*;
import pokecomp.stats.Stats;
import pokedex.*;
import pokemon.Pokemon;
import pokemon.PokemonEntity;

import javax.swing.JOptionPane;

public class App {
    public static Battle batalha = new Battle();
    static int op;

    public static void main(String[] args) throws Exception {

        Random rand = new Random();
        Pokedex pkms = new Pokedex();
        Pokemon[] pokemons = pkms.pokemonsEntrada(pkms.pokemonLista);
        PokemonEntity jogador;
        PokemonEntity inimigo;
        int escInimigo = rand.nextInt(3);
        String msg = "";
        for (int i = 0; i < pokemons.length; i++) {
            msg += i + "\n" + pokemons[i].getName() + " - " + pokemons[i].getTypeOne() + "/" + pokemons[i].getTypeTwo()
                    + "\n";
        }
        op = Integer.parseInt(
                JOptionPane.showInputDialog(

                        "Qual Pokémon você quer?:\n" + msg));

        jogador = gerarPokemon(pokemons[op]);
        inimigo = gerarPokemon(pokemons[escInimigo]);
        JOptionPane.showMessageDialog(null, jogador.getName() + "\n" + jogador.getHp() + "\n" + jogador.getLevel());
        batalha.batalhaAtiva(jogador, inimigo);
    }

    public static PokemonEntity gerarPokemon(Pokemon pokemon) {
        Random rand = new Random();

        PokemonEntity pkm = new PokemonEntity(rand.nextInt(10000), pokemon.getName(), 10, pokemon, Stats.NULO);
        return pkm;
    }
}
