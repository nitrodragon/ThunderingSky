package com.thunder.sky;

import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.floor;
import static java.lang.Math.pow;

/**
 * REAGAN LAND ONLY
 *
 * This class provides formulas used
 * by other classes such as players
 * and monsters.
 */
 //interface? 
class Formulas {

    static int getHPStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10; // Hecka long formula
    }

    static int getOtherStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5; // Hecka long formula
    }

    static int calculateNext(int level, int classNum) {
        if (classNum == 0) {
            return (int) floor(pow(4 * level, 3) / 5);
        } else if (classNum == 1) {
            return level ^ 3;
        } else if (classNum == 2) {
            return (int) floor((pow(((6.0/5.0)*level), 3)) - pow((15 * level), 2) + (100 * level) - 140); // Oh dear goodness I liked the class 2s until this
            // Hooray for polynomials amirite
        } else if (classNum == 3) {
            return (int) floor(pow(5 * level, 3) / 4);
        } else return 1000000; // Suck it, cheaters
    }

    // Monster damageFormula
    private int damageFormula(Player player, int monsterDef) {
        int power = 15; // Implementing 15 here in place of a weapon!
        int playerLevel = player.getLevel();
        int playerAtk = player.getAtk();
        double modifier = ThreadLocalRandom.current().nextDouble(0.85, 1.0);
        return (int) floor((((((2 * playerLevel) / 5) + 2) * power * (playerAtk / monsterDef) / 50) + 2) * modifier);
    }

    // Unused weird stuff? TODO: Delete or use them
    public int setHP(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10;
    }

    public int setOther(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5;
    }

}
