import static java.lang.Math.floor;
/**
 * Created by nitrodragon on 4/9/2017.
 */
public class Stats implements BasesGalore {

    private static int BaseHP;
    private static int BaseAtk;
    private static int BaseDef;
    private static int BaseMag;
    private static int BaseSpd;
    private static String cc;

    private static int getCharacterClass(int a, int d, int m, int s) {
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

    private static int fa = 1;
    private static int fd = 0;
    private static int fm = 1;
    private static int fs = 0;

    public static BaseCharacter getCharacter(int index) {
        cc = characters[index].getCharacterClass();
        BaseHP = characters[index].getHP();
        BaseAtk = characters[index].getATK();
        BaseDef = characters[index].getDEF();
        BaseMag = characters[index].getMAG();
        BaseSpd = characters[index].getSPD();
        return characters[index];
    }

    private static int HpIV = 0; // Will be random and static from the start of the game onward
    private static int AtkIV = 0;
    private static int DefIV = 0;
    private static int MagIV = 0;
    private static int SpdIV = 0;

    private static int HpEV = 0; // Will constantly go up throughout the game
    private static int AtkEV = 0;
    private static int DefEV = 0;
    private static int MagEV = 0;
    private static int SpdEV = 0;

    private static int level = 10; // Will constantly go up throughout the game

    private static int Hp, Atk, Def, Mag, Spd; // Define variables for the stats

    private static int getHPStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + level + 10; // Hecka long formula
    }

    private static int getOtherStat(int base, int level, int iv, int ev) {
        return (int) floor((((base + iv) * 2 + ((Math.sqrt(ev) / 4))) * level) / 100) + 5; // Hecka long formula
    }

    private static void setAllStats() {
        Hp = getHPStat(BaseHP, level, HpIV, HpEV);
        Atk = getOtherStat(BaseAtk, level, AtkIV, AtkEV);
        Def = getOtherStat(BaseDef, level, DefIV, DefEV);
        Mag = getOtherStat(BaseMag, level, MagIV, MagEV);
        Spd = getOtherStat(BaseSpd, level, SpdIV, SpdEV);
    }

    public static void main(String[] args) {
        getCharacter(getCharacterClass(fa, fd, fm, fs));
        setAllStats();
        System.out.println(cc);
        System.out.println("Hp = " + Hp);
        System.out.println("Atk = " + Atk);
        System.out.println("Def = " + Def);
        System.out.println("Mag = " + Mag);
        System.out.println("Spd = " + Spd);
    }

}
