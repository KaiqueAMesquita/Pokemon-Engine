package pokemon;

public enum Nature {
    HARDY(1.0, 1.0, 1.0, 1.0, 1.0),
    LONELY(1.1, 0.9, 1.0, 1.0, 1.0),
    BRAVE(1.1, 1.0, 1.0, 1.0, 0.9),
    ADAMANT(1.1, 1.0, 0.9, 1.0, 1.0),
    NAUGHTY(1.1, 1.0, 1.0, 0.9, 1.0),
    BOLD(0.9, 1.1, 1.0, 1.0, 1.0),
    DOCILE(1.0, 1.0, 1.0, 1.0, 1.0),
    RELAXED(1.0, 1.1, 1.0, 1.0, 0.9),
    IMPISH(1.0, 1.1, 0.9, 1.0, 1.0),
    LAX(1.0, 1.1, 1.0, 0.9, 1.0),
    TIMID(0.9, 1.0, 1.0, 1.0, 1.1),
    HASTY(1.0, 0.9, 1.0, 1.0, 1.1),
    SERIOUS(1.0, 1.0, 1.0, 1.0, 1.0),
    JOLLY(1.0, 1.0, 0.9, 1.0, 1.1),
    NAIVE(1.0, 1.0, 1.0, 0.9, 1.1),
    MODEST(0.9, 1.0, 1.1, 1.0, 1.0),
    MILD(1.0, 1.0, 1.1, 0.9, 1.0),
    QUIET(1.0, 1.0, 1.1, 1.0, 0.9),
    BASHFUL(1.0, 1.0, 1.0, 1.0, 1.0),
    RASH(1.0, 1.0, 1.1, 0.9, 1.0),
    CALM(0.9, 1.0, 1.0, 1.1, 1.0),
    GENTLE(1.0, 0.9, 1.0, 1.1, 1.0),
    SASSY(1.0, 1.0, 1.0, 1.1, 0.9),
    CAREFUL(1.0, 1.0, 0.9, 1.1, 1.0),
    QUIRKY(1.0, 1.0, 1.0, 1.0, 1.0);

    private final double attackMod;
    private final double defenseMod;
    private final double spdAttackMod;
    private final double spdDefenseMod;
    private final double speedMod;

    Nature(double attackMod, double defenseMod, double spdAttackMod, double spdDefenseMod, double speedMod) {
        this.attackMod = attackMod;
        this.defenseMod = defenseMod;
        this.spdAttackMod = spdAttackMod;
        this.spdDefenseMod = spdDefenseMod;
        this.speedMod = speedMod;
    }

    public double getAttackMod() {
        return attackMod;
    }

    public double getDefenseMod() {
        return defenseMod;
    }

    public double getSpdAttackMod() {
        return spdAttackMod;
    }

    public double getSpdDefenseMod() {
        return spdDefenseMod;
    }

    public double getSpeedMod() {
        return speedMod;
    }
}
