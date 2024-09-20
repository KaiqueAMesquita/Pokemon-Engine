package pokedex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pokecomp.move.DamageMove;
import pokecomp.move.Function;
import pokecomp.move.Move;
import pokecomp.points.LevelGrowth;
import pokecomp.status.Status;
import pokemon.Pokemon;
import pokemon.Types;

public class MoveGenerator {
    public static ArrayList<Move> moveArray = new ArrayList<>();

    public MoveGenerator() {
        moveArray = generateList();
    }

    public ArrayList<Move> generateList() {
        ArrayList<Move> moves = new ArrayList<>();
        try {
            FileReader arq = new FileReader("src/assets/moves.txt");
            BufferedReader readFile = new BufferedReader(arq);

            String line = readFile.readLine();

            while (line != null) {
                if (line.equals("#------#")) {
                    int id = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    String name = readFile.readLine().split(": ")[1].trim();
                    String category = readFile.readLine().split(": ")[1].trim();
                    String type = readFile.readLine().split(": ")[1].trim();
                    Types typeO = Types.valueOf(type);
                    int pp = Integer.parseInt(readFile.readLine().split(": ")[1]);
                    String[] define = readFile.readLine().split(": ");
                    int power = 40;
                    int priority = 0;
                    int accuracy = 100;
                    if (define.length > 1) {
                        define = define[1].split(", ");
                        if (define.length > 2) {
                            power = Integer.parseInt(define[0].trim());
                            priority = Integer.parseInt(define[1].trim());
                            accuracy = Integer.parseInt(define[2].trim());
                        }
                    }

                    Status status = null;
                    int effect = 0;
                    int effectChance = 0;
                    String eline = readFile.readLine();
                    if (eline != null && line.startsWith("effect:")) {
                        String[] effects = line.split(": ")[1].split(", ");
                        if (effects.length > 1) {
                            effect = Integer.parseInt(effects[0].trim());
                            effectChance = Integer.parseInt(effects[1].trim());
                        } else {
                            effect = Integer.parseInt(effects[0].trim());
                            effectChance = 0;
                        }
                    } else {
                        effect = 0;
                        effectChance = 0;
                    }

                    Function function = null;
                    line = readFile.readLine(); // Tente ler a próxima linha para verificar a função
                    if (line != null && line.contains("function")) {
                        function = Function.valueOf(line.split(": ")[1].trim());
                    } else {
                        // Se não houver função, reverte a linha para continuar com a leitura
                        line = null; // Define como nulo para evitar loop
                    }

                    Move move = null;
                    if (category.equals("Physical") || category.equals("Special")) {
                        move = new DamageMove(id, name, typeO, pp, priority, accuracy, power, status, effectChance,
                                function, category);
                    }

                    if (move != null) {
                        moves.add(move);
                    }
                }

                line = readFile.readLine(); // Continue lendo o arquivo
            }

            readFile.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.printf("Erro de formato: %s.\n", e.getMessage());
        }
        return moves;
    }

}