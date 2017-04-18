package com.thunder.sky;

import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.floor;

public class Player implements BasesGalore, Monsters {

    // These are the default class values, non-unique
    private int BaseHP;
    private int BaseAtk;
    private int BaseDef;
    private int BaseMag;
    private int BaseSpd;
    private String cc;
    private BaseCharacter stats;
    private int Level = 90;

    // Will be random and from the start of the game onward
    private int HpIV = ThreadLocalRandom.current().nextInt(0, 16);
    private int AtkIV = ThreadLocalRandom.current().nextInt(0, 16);
    private int DefIV = ThreadLocalRandom.current().nextInt(0, 16);
    private int MagIV = ThreadLocalRandom.current().nextInt(0, 16);
    private int SpdIV = ThreadLocalRandom.current().nextInt(0, 16);

    // Will constantly go up throughout the game
    private int HpEV = 0;
    private int AtkEV = 0;
    private int DefEV = 0;
    private int MagEV = 0;
    private int SpdEV = 0;

    // Stats that can change
    private int Hp, Atk, Def, Mag, Spd, level;

    public Player(int fa, int fd, int fm, int fs) {
        stats = getCharacter(getCharacterClass(fa, fd, fm, fs));
        resetStats();
        System.out.println("Welcome player, you are a " + cc + ". " + "At level " + level + ".");
        System.out.println("Hp = " + getHp());
        System.out.println("Atk = " + getAtk());
        System.out.println("Def = " + getDef());
        System.out.println("Mag = " + getMag());
        System.out.println("Spd = " + getSpd());
        // Enter test fights below here!
        Monster mnt = new Monster(this, ZOMBIE, false); // this represents the current player
    }

    public static int getCharacterClass(int a, int d, int m, int s) {
        if (a == 0 && d == 0 && m == 0 && s == 0) return VILLAGER;
        // C1
        if (a == 1 && d == 0 && m == 0 && s == 0) return FIGHTER;
        if (a == 0 && d == 1 && m == 0 && s == 0) return GUARD;
        if (a == 0 && d == 0 && m == 1 && s == 0) return SPELLCASTER;
        if (a == 0 && d == 0 && m == 0 && s == 1) return ATHLETE;
        // C2
        if (a == 1 && d == 1 && m == 0 && s == 0) return KNIGHT;
        if (a == 1 && d == 0 && m == 1 && s == 0) return SPELLSWORD;
        if (a == 1 && d == 0 && m == 0 && s == 1) return MARTIALARTIST;
        if (a == 0 && d == 1 && m == 1 && s == 0) return CLERIC;
        if (a == 0 && d == 1 && m == 0 && s == 1) return ESCAPIST;
        if (a == 0 && d == 0 && m == 1 && s == 1) return EXPEDITER;
        if (a == 2 && d == 0 && m == 0 && s == 0) return SLAYER;
        if (a == 0 && d == 2 && m == 0 && s == 0) return DEFENDER;
        if (a == 0 && d == 0 && m == 2 && s == 0) return MAGICIAN;
        if (a == 0 && d == 0 && m == 0 && s == 2) return GUERRILLA;
        // C3
        if (a == 1 && d == 1 && m == 1 && s == 0) return PALADIN;
        if (a == 1 && d == 0 && m == 1 && s == 1) return ARCHER;
        if (a == 0 && d == 1 && m == 1 && s == 1) return MONK;
        if (a == 1 && d == 1 && m == 0 && s == 1) return CAVALIER;
        if (a == 1 && d == 2 && m == 0 && s == 0) return SAMURAI;
        if (a == 0 && d == 2 && m == 1 && s == 0) return SHELLCASTER;
        if (a == 0 && d == 2 && m == 0 && s == 1) return ARMADILLO;
        if (a == 1 && d == 0 && m == 2 && s == 0) return NECROMANCER;
        if (a == 0 && d == 1 && m == 2 && s == 0) return DIVINER;
        if (a == 0 && d == 0 && m == 2 && s == 1) return CONJUROR;
        if (a == 0 && d == 1 && m == 0 && s == 2) return SPY;
        if (a == 1 && d == 0 && m == 0 && s == 2) return DRAGOON;
        if (a == 0 && d == 0 && m == 1 && s == 2) return TIMEMAGE;
        if (a == 3 && d == 0 && m == 0 && s == 0) return DEATHBRINGER;
        if (a == 0 && d == 3 && m == 0 && s == 0) return IRONSIDE;
        if (a == 0 && d == 0 && m == 3 && s == 0) return ELEMANCER;
        if (a == 0 && d == 0 && m == 0 && s == 3) return VELOXLUX;
        if (a == 2 && d == 1 && m == 0 && s == 0) return GLADIATOR;
        if (a == 2 && d == 0 && m == 1 && s == 0) return SOULEATER;
        if (a == 2 && d == 0 && m == 0 && s == 1) return ASSASSIN;
        return VILLAGER;
    }

    // Quick way to get the player's class name
    public static String getPlayerName(int index) {
        return characters[index].getCharacterClass();
    }

    private BaseCharacter getCharacter(int index) {
        cc = characters[index].getCharacterClass();
        BaseHP = characters[index].getHP();
        BaseAtk = characters[index].getATK();
        BaseDef = characters[index].getDEF();
        BaseMag = characters[index].getMAG();
        BaseSpd = characters[index].getSPD();
        resetStats();
        setAllStats();
        return characters[index];
    }


    private void resetStats() {
        level = Level;
        Hp = BaseHP;
        Atk = BaseAtk;
        Def = BaseDef;
        Mag = BaseMag;
        Spd = BaseSpd;
    }

    private void setAllStats() {
        Hp = Formulas.getHPStat(BaseHP, Level, HpIV, HpEV);
        Atk = Formulas.getOtherStat(BaseAtk, Level, AtkIV, AtkEV);
        Def = Formulas.getOtherStat(BaseDef, Level, DefIV, DefEV);
        Mag = Formulas.getOtherStat(BaseMag, Level, MagIV, MagEV);
        Spd = Formulas.getOtherStat(BaseSpd, Level, SpdIV, SpdEV);
    }

    // Getters and Setters
    int getLevel() {
        return level;
    }

    int getHp() {
        return Hp;
    }

    int getAtk() { return Atk; }

    int getDef() {
        return Def;
    }

    int getMag() {
        return Mag;
    }

    int getSpd() { return Spd; }

    void setHp(int hp) {
        Hp = hp;
    }

    void setHpEV(int hpEV) {
        HpEV = hpEV;
    }

    void setAtkEV(int atkEV) {
        AtkEV = atkEV;
    }

    void setDefEV(int defEV) {
        DefEV = defEV;
    }

    void setMagEV(int magEV) {
        MagEV = magEV;
    }

    void setSpdEV(int spdEV) {
        SpdEV = spdEV;
    }

    int getHpEV() {
        return HpEV;
    }

    int getAtkEV() {
        return AtkEV;
    }

    int getDefEV() {
        return DefEV;
    }

    int getMagEV() {
        return MagEV;
    }

    int getSpdEV() {
        return SpdEV;
    }
}
