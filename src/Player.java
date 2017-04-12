import static java.lang.Math.floor;
/**
 * Created by nitrodragon on 4/9/2017.
 */
public class Player implements BasesGalore, Monsters  {

    private int BaseHP;
    private int BaseAtk;
    private int BaseDef;
    private int BaseMag;
    private int BaseSpd;
    private String cc;
    BaseCharacter stats;

    Player(int fa, int fd, int fm, int fs) {
        stats = getCharacter(getCharacterClass(fa, fd, fm, fs));
        setAllStats();
        System.out.println("Welcome player, you are a " + cc + ".");
        System.out.println("Hp = " + Hp);
        System.out.println("Atk = " + Atk);
        System.out.println("Def = " + Def);
        System.out.println("Mag = " + Mag);
        System.out.println("Spd = " + Spd);
        // Enter test fights below here!
        Monster mnt = new Monster(this, SLIME, false); // this represents the current player
    }

    private int getCharacterClass(int a, int d, int m, int s) {
        if (a == 0 && d == 0 && m == 0 && s == 0) {return VILLAGER;}
        if (a == 1 && d == 0 && m == 0 && s == 0) {return FIGHTER;}
        if (a == 0 && d == 1 && m == 0 && s == 0) {return GUARD;}
        if (a == 0 && d == 0 && m == 1 && s == 0) {return SPELLCASTER;}
        if (a == 0 && d == 0 && m == 0 && s == 1) {return ATHLETE;}
        if (a == 1 && d == 1 && m == 0 && s == 0) {return KNIGHT;}
        if (a == 1 && d == 0 && m == 1 && s == 0) {return SPELLSWORD;}
        if (a == 1 && d == 0 && m == 0 && s == 1) {return MARTIALARTIST;}
        if (a == 0 && d == 1 && m == 1 && s == 0) {return CLERIC;}
        if (a == 0 && d == 1 && m == 0 && s == 1) {return ESCAPIST;}
        if (a == 0 && d == 0 && m == 1 && s == 1) {return EXPEDITER;}
        if (a == 2 && d == 0 && m == 0 && s == 0) {return SLAYER;}
        if (a == 0 && d == 2 && m == 0 && s == 0) {return DEFENDER;}
        if (a == 0 && d == 0 && m == 2 && s == 0) {return MAGICIAN;}
        if (a == 0 && d == 0 && m == 0 && s == 2) {return GUERRILLA;}
        else return VILLAGER;
    }

    private BaseCharacter getCharacter(int index) {
        cc = characters[index].getCharacterClass();
        BaseHP = characters[index].getHP();
        BaseAtk = characters[index].getATK();
        BaseDef = characters[index].getDEF();
        BaseMag = characters[index].getMAG();
        BaseSpd = characters[index].getSPD();
        return characters[index];
    }

    // TODO Implement these

    private int HpIV = 0; // Will be random and from the start of the game onward
    private int AtkIV = 0;
    private int DefIV = 0;
    private int MagIV = 0;
    private int SpdIV = 0;

    private int HpEV = 0; // Will constantly go up throughout the game
    private int AtkEV = 0;
    private int DefEV = 0;
    private int MagEV = 0;
    private int SpdEV = 0;

    private int level = 10; // Will constantly go up throughout the game

    private int Hp, Atk, Def, Mag, Spd; // Define variables for the stats

    private int getHPStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10; // Hecka long formula
    }

    private int getOtherStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5; // Hecka long formula
    }

    private void setAllStats() {
        Hp = getHPStat(BaseHP, level, HpIV, HpEV);
        Atk = getOtherStat(BaseAtk, level, AtkIV, AtkEV);
        Def = getOtherStat(BaseDef, level, DefIV, DefEV);
        Mag = getOtherStat(BaseMag, level, MagIV, MagEV);
        Spd = getOtherStat(BaseSpd, level, SpdIV, SpdEV);
    }

    // Getters and Setters

    int getHp() {
        return Hp;
    }

    int getAtk() {
        return Atk;
    }

    int getDef() {
        return Def;
    }

    int getMag() {
        return Mag;
    }

    int getSpd() {
        return Spd;
    }

    void setHp(int hp) {
        Hp = hp;
    }

    void setAtk(int atk) {
        Atk = atk;
    }

    void setDef(int def) {
        Def = def;
    }

    void setMag(int mag) {
        Mag = mag;
    }

    void setSpd(int spd) {
        Spd = spd;
    }
}
