import java.util.concurrent.ThreadLocalRandom;
import static java.lang.Math.floor;

class Player implements BasesGalore, Monsters {

    private int BaseHP;
    private int BaseAtk;
    private int BaseDef;
    private int BaseMag;
    private int BaseSpd;
    private String cc;
    BaseCharacter stats;

    Player(int fa, int fd, int fm, int fs) {
        stats = getCharacter(getCharacterClass(fa, fd, fm, fs));
        resetStats();
        System.out.println("Welcome player, you are a " + cc + ".");
        System.out.println("Hp = " + getHp());
        System.out.println("Atk = " + getAtk());
        System.out.println("Def = " + getDef());
        System.out.println("Mag = " + getMag());
        System.out.println("Spd = " + getSpd());
        // Enter test fights below here!
        Monster mnt = new Monster(this, ZOMBIE, false); // this represents the current player
        System.out.println(AtkEV);
    }

    private int getCharacterClass(int a, int d, int m, int s) {
        if (a == 0 && d == 0 && m == 0 && s == 0) {
            return VILLAGER;
        }
        // C1
        if (a == 1 && d == 0 && m == 0 && s == 0) {
            return FIGHTER;
        }
        if (a == 0 && d == 1 && m == 0 && s == 0) {
            return GUARD;
        }
        if (a == 0 && d == 0 && m == 1 && s == 0) {
            return SPELLCASTER;
        }
        if (a == 0 && d == 0 && m == 0 && s == 1) {
            return ATHLETE;
        }
        // C2
        if (a == 1 && d == 1 && m == 0 && s == 0) {
            return KNIGHT;
        }
        if (a == 1 && d == 0 && m == 1 && s == 0) {
            return SPELLSWORD;
        }
        if (a == 1 && d == 0 && m == 0 && s == 1) {
            return MARTIALARTIST;
        }
        if (a == 0 && d == 1 && m == 1 && s == 0) {
            return CLERIC;
        }
        if (a == 0 && d == 1 && m == 0 && s == 1) {
            return ESCAPIST;
        }
        if (a == 0 && d == 0 && m == 1 && s == 1) {
            return EXPEDITER;
        }
        if (a == 2 && d == 0 && m == 0 && s == 0) {
            return SLAYER;
        }
        if (a == 0 && d == 2 && m == 0 && s == 0) {
            return DEFENDER;
        }
        if (a == 0 && d == 0 && m == 2 && s == 0) {
            return MAGICIAN;
        }
        if (a == 0 && d == 0 && m == 0 && s == 2) {
            return GUERRILLA;
        }
        // C3
        if (a == 1 && d == 1 && m == 1 && s == 0) {
            return PALADIN;
        }
        if (a == 1 && d == 0 && m == 1 && s == 1) {
            return ARCHER;
        }
        if (a == 0 && d == 1 && m == 1 && s == 1) {
            return MONK;
        }
        if (a == 1 && d == 1 && m == 0 && s == 1) {
            return CAVALIER;
        }
        if (a == 1 && d == 2 && m == 0 && s == 0) {
            return SAMURAI;
        }
        if (a == 0 && d == 2 && m == 1 && s == 0) {
            return SHELLCASTER;
        }
        if (a == 0 && d == 2 && m == 0 && s == 1) {
            return ARMADILLO;
        }
        if (a == 1 && d == 0 && m == 2 && s == 0) {
            return NECROMANCER;
        }
        if (a == 0 && d == 1 && m == 2 && s == 0) {
            return DIVINER;
        }
        if (a == 0 && d == 0 && m == 2 && s == 1) {
            return CONJUROR;
        }
        if (a == 0 && d == 1 && m == 0 && s == 2) {
            return SPY;
        }
        if (a == 1 && d == 0 && m == 0 && s == 2) {
            return DRAGOON;
        }
        if (a == 0 && d == 0 && m == 1 && s == 2) {
            return TIMEMAGE;
        }
        if (a == 3 && d == 0 && m == 0 && s == 0) {
            return DEATHBRINGER;
        }
        if (a == 0 && d == 3 && m == 0 && s == 0) {
            return IRONSIDE;
        }
        if (a == 0 && d == 0 && m == 3 && s == 0) {
            return ELEMANCER;
        }
        if (a == 0 && d == 0 && m == 0 && s == 3) {
            return VELOXLUX;
        }
        if (a == 2 && d == 1 && m == 0 && s == 0) {
            return GLADIATOR;
        }
        if (a == 2 && d == 0 && m == 1 && s == 0) {
            return SOULEATER;
        }
        if (a == 2 && d == 0 && m == 0 && s == 1) {
            return ASSASSIN;
        } else return VILLAGER;
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

    private double HpIV = ThreadLocalRandom.current().nextDouble(0.8, 1.2); // Will be random and from the start of the game onward
    private double AtkIV = ThreadLocalRandom.current().nextDouble(0.8, 1.2);
    private double DefIV = ThreadLocalRandom.current().nextDouble(0.8, 1.2);
    private double MagIV = ThreadLocalRandom.current().nextDouble(0.8, 1.2);
    private double SpdIV = ThreadLocalRandom.current().nextDouble(0.8, 1.2);

    private int HpEV = 0; // Will constantly go up throughout the game
    private int AtkEV = 0;
    private int DefEV = 0;
    private int MagEV = 0;
    private int SpdEV = 0;// Also, they're gonna be awarded by the monsters, so we've gotta implement these ASAP.

    private int level = 10; // Will constantly go up throughout the game

    private int Hp, Atk, Def, Mag, Spd; // Define variables for the stats

    private int getHPStat(int base, int level, int ev) {
        return (int) floor(((base * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10; // Hecka long formula
    }

    private int getOtherStat(int base, int level, int ev) {
        return (int) floor(((base * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5; // Hecka long formula
    }

    private void resetStats() {
        Hp = BaseHP;
        Atk = BaseAtk;
        Def = BaseDef;
        Mag = BaseMag;
        Spd = BaseSpd;
    }

    private void setAllStats() {
        Hp = getHPStat(BaseHP, level, HpEV);
        System.out.println(Hp);
        Atk = getOtherStat(BaseAtk, level, AtkEV);
        Def = getOtherStat(BaseDef, level, DefEV);
        Mag = getOtherStat(BaseMag, level, MagEV);
        Spd = getOtherStat(BaseSpd, level, SpdEV);
    }

    // Getters and Setters

    int getLevel() {
        return level;
    }

    int getHp() {
        return (int) Math.floor(Hp * HpIV);
    }

    int getAtk() {
        return (int) Math.floor(Atk * AtkIV);
    }

    int getDef() {
        return (int) Math.floor(Def * DefIV);
    }

    int getMag() {
        return (int) Math.floor(Mag * MagIV);
    }

    int getSpd() {
        return (int) Math.floor(Spd * SpdIV);
    }

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
