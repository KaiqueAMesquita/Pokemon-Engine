package pokedex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.text.Style;

import pokemon.*;
import pokecomp.attacks.*;
import pokecomp.points.LevelGrowth;

public class GenerateDex {

    public static ArrayList<Pokemon> pokemonsArray = new ArrayList<>();
    public AttackList atk = new AttackList();

    public GenerateDex() {
        pokemonsArray = generateList();
    }

    public ArrayList<Pokemon> generateList() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try {
            FileReader arq = new FileReader("src/assets/pokedex.txt");
            BufferedReader readFile = new BufferedReader(arq);

            String line = readFile.readLine();

            while (line != null) {
                if (line.equals("#-------#")) {
                    String name = readFile.readLine().split(": ")[1];
                    String[] tipos = readFile.readLine().split(": ")[1].split(", "); // Divide os tipos em um array
                    String type1 = tipos[0].replace(",", "").trim();
                    String type2 = tipos.length > 1 ? tipos[1] : null;
                    Types typeO = Types.valueOf(type1);
                    Types typeT = null;
                    if (type2 != null) {
                        typeT = Types.valueOf(type2);
                    }
                    int hp = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    int speed = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    int attack = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    int spdAttack = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    int defense = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    int spdDefense = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    String level = readFile.readLine().split(": ")[1];
                    LevelGrowth levelType = LevelGrowth.valueOf(level);
                    Pokemon p = new Pokemon(name, hp, speed, attack, spdAttack, defense, spdDefense, typeO, typeT,
                            levelType, preencherAtaques(atk.ataquesLista), 10);
                    pokemons.add(p);

                } else {
                    break;
                }
                line = readFile.readLine();

            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println(pokemons);
        return pokemons;
    }

    public static Attacks[] preencherAtaques(ArrayList<Attacks> atqs) {
        Attacks[] ataques = new Attacks[atqs.size()];
        for (int i = 0; i < atqs.size(); i++) {
            ataques[i] = atqs.get(i);
        }
        return ataques;
    }

}
