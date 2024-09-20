package main;

import javax.swing.JOptionPane;

import pokecomp.move.Move;
import pokedex.GenerateDex;
import pokedex.MoveGenerator;
import pokemon.Pokemon;

public class GameData {
    private GenerateDex dex = new GenerateDex();
    private MoveGenerator moveGen = new MoveGenerator();
    private Pokemon[] pokemons = new Pokemon[dex.pokemonsArray.size()];
    private Move[] moves = new Move[moveGen.moveArray.size()];

    public GameData() {
        addMoves();
        addPokemons();

    }

    private void addPokemons() {
        for (int i = 0; i < dex.pokemonsArray.size(); i++) {
            pokemons[i] = dex.pokemonsArray.get(i);
        }
    }

    private void addMoves() {
        for (int i = 0; i < moveGen.moveArray.size(); i++) {
            moves[i] = moveGen.moveArray.get(i);
        }
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public Move[] getMoves() {
        return moves;
    }

    public void showPokemon(int index) {
        JOptionPane.showMessageDialog(null, getPokemons()[index].getName() + "\n" + getPokemons()[index].getTypeOne());
    }

    public void showMove(int index) {
        JOptionPane.showMessageDialog(null, getMoves()[index].getName() + "\n" + getMoves()[index].getType()
                + "\n Power: " + getMoves()[index].getPower());
    }

}