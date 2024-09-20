package pokemon;

import pokecomp.points.LevelGrowth;
import pokecomp.status.*;

import java.util.Random;

import javax.swing.JOptionPane;

import pokecomp.move.Move;

public class PokemonEntity {
    private int id;
    private String name;
    private int level;
    private int hp;
    private int attack;
    private int defense;
    private int spdAttack;
    private int spdDefense;
    private int speed;
    private int xp;
    private Pokemon pokemon;
    private Move[] moves = new Move[4];
    private Status status;
    private int maxHp;
    private Nature nature;
    private int[] individualValues = new int[5];

    public PokemonEntity(int id, String name, int level, Pokemon pokemon, Status status) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.pokemon = pokemon;
        this.calculateIv();
        this.maxHp = calculateHp(individualValues[0]);
        this.hp = this.maxHp;
        this.attack = calculateOtherStats("Attack", individualValues[1]);
        this.defense = calculateOtherStats("Defense", individualValues[2]);
        this.spdAttack = calculateOtherStats("SpdMAttack", individualValues[3]);
        this.spdDefense = calculateOtherStats("SpdDefense", individualValues[4]);
        this.speed = calculateOtherStats("Speed", individualValues[5]);
        this.xp = calculateXpForLevel(level);
        this.moves = putMoves();
        this.nature = generateNature();
        this.status = null;

    }

    private Nature generateNature() {
        Random rand = new Random();
        int nature = rand.nextInt(25);
        return Nature.values()[nature];
    }

    private void calculateIv() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int iv = rand.nextInt(32);
            this.individualValues[i] = iv;
        }
    }

    private int calculateXpForLevel(int level) {
        LevelGrowth type = pokemon.getLevelType();
        switch (type) {
            case FAST:
                return calculateFastExperience(level);
            case MEDIUM_FAST:
                return calculateMediumFastExperience(level);
            case MEDIUM_SLOW:
                return calculateMediumSlowExperience(level);
            case SLOW:
                return calculateSlowExperience(level);
            case ERRATIC:
                return calculateErraticExperience(level);
            case FLUCTUATING:
                return calculateFluctuatingExperience(level);
            default:
                return 0;
        }
    }

    private int calculateFastExperience(int level) {
        return (4 * level * level * level) / 5;
    }

    private int calculateMediumFastExperience(int level) {
        return level * level * level;
    }

    private int calculateMediumSlowExperience(int level) {
        return (6 * level * level * level) / 5 - 15 * level * level + 100 * level - 140;
    }

    private int calculateSlowExperience(int level) {
        return (5 * level * level * level) / 4;
    }

    private int calculateErraticExperience(int level) {
        if (level < 50) {
            return (int) Math.pow(level, 3) * (100 - level) / 50;
        } else if (level < 68) {
            return (int) Math.pow(level, 3) * (150 - level) / 100;
        } else if (level < 98) {
            return (int) Math.pow(level, 3) * (1911 - 10 * level / 3);
        } else {
            return (int) Math.pow(level, 3) * (160 - level) / 100;
        }
    }

    private int calculateFluctuatingExperience(int level) {
        if (level < 15) {
            return (int) Math.pow(level, 3) * ((level + 1) / 3 + 24) / 50;
        } else if (level < 36) {
            return (int) Math.pow(level, 3) * (level + 14) / 50;
        } else {
            return (int) Math.pow(level, 3) * (level / 2 + 32) / 50;
        }
    }

    public void LevelUp() {
        if (calculateXpForLevel(level + 1) <= xp) {
            level++;
            JOptionPane.showMessageDialog(null, this.name + " subiu para o nível " + this.level);
            for (int j = pokemon.getLearningLevel().length; j > 0; j--) {
                if (pokemon.getLearningLevel()[j] == level) {
                    int resposta = JOptionPane.showConfirmDialog(null,
                            "Deseja aprender? " + pokemon.getMoves()[j], "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        this.moves[3] = pokemon.getMoves()[j];
                    } else {
                        JOptionPane.showMessageDialog(null, "Você NÃO quis aprender o ataque!");
                        break;
                    }
                }
            }
        }
    }

    public Move[] putMoves() {
        Move[] moves = new Move[4]; // Tamanho máximo do array de ataques
        int count = 0; // Contador para o número de ataques adicionados

        // Itera sobre os ataques disponíveis do Pokémon
        for (int i = 0; i < pokemon.getMoves().length; i++) {
            // z
            if (count < 4 && pokemon.getLearningLevel()[i] <= level) {
                moves[count] = pokemon.getMoves()[i]; // Adiciona o ataque ao array de ataques
                count++; // Incrementa o contador
            }
        }

        return moves;
    }

    public boolean attackIsNull(int i) {
        return this.moves[i] == null;
    }

    public int calculateHp(int iv) {
        int realHp = ((2 * this.pokemon.getHp() + iv + (pokemon.getEv(0) / 4)) * this.level / 100) + this.level + 10;

        return realHp;
    }

    public int calculateOtherStats(String stat, int iv) {
        int realStat = 0;

        switch (stat) {
            case "Attack":
                realStat = (int) (((2 * this.pokemon.getAttack() + iv + (pokemon.getEv(2) / 4) * this.level / 100) + 5)
                        * nature.getAttackMod());
                break;
            case "Defense":
                realStat = (int) (((2 * this.pokemon.getDefense() + iv + (pokemon.getEv(4) / 4) * this.level / 100) + 5)
                        * nature.getDefenseMod());

                break;
            case "SpdAttack":
                realStat = (int) (((2 * this.pokemon.getSpdAttack() + iv + (pokemon.getEv(3) / 4) * this.level / 100)
                        + 5) * nature.getSpdAttackMod());

                break;
            case "SpdDefense":
                realStat = (int) (((2 * this.pokemon.getSpdDefense() + iv + (pokemon.getEv(5) / 4) * this.level / 100)
                        + 5) * nature.getSpdDefenseMod());

                break;
            case "Speed":
                realStat = (int) (((2 * this.pokemon.getSpeed() + iv + (pokemon.getEv(1) / 4) * this.level / 100) + 5)
                        * nature.getSpeedMod());

                break;

        }

        return realStat;
    }

    // verifica se o slot de ataque está vazio
    public boolean moveNull(int i) {
        if (this.moves[i] == null)
            return true;
        else
            return false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int d) {
        this.defense = d;
    }

    public int getSpdAttack() {
        return this.spdAttack;
    }

    public void setSpdAttack(int spdAttack) {
        this.spdAttack = spdAttack;
    }

    public int getSpdDefense() {
        return this.spdDefense;
    }

    public void setSpdDefense(int spdDefense) {
        this.spdDefense = spdDefense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXp() {
        return this.xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Pokemon getPokemon() {
        return this.pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status s) {
        this.status = s;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void setMaxHP(int hp) {
        this.maxHp = hp;
    }

    public Move[] getMoves() {
        return this.moves;
    }

    public Move getMove(int i) {
        return this.moves[i];
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    // get e set nature
    public Nature getNature() {
        return this.nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

}