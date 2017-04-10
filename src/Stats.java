import static java.lang.Math.floor;
/**
 * Created by nitrodragon on 4/9/2017.
 */
public class Stats implements BasesGalore {


    private static String getCharacterClass(int a, int d, int m, int s) {
        if (a == 0 && d == 0 && m == 0 && s == 0) {return "villager";}
        if (a == 1 && d == 0 && m == 0 && s == 0) {return "fighter";}
        if (a == 0 && d == 1 && m == 0 && s == 0) {return "guard";}
        if (a == 0 && d == 0 && m == 1 && s == 0) {return "spellcaster";}
        if (a == 0 && d == 0 && m == 0 && s == 1) {return "athlete";}
        if (a == 1 && d == 1 && m == 0 && s == 0) {return "knight";}
        if (a == 1 && d == 0 && m == 1 && s == 0) {return "spellsword";}
        if (a == 1 && d == 0 && m == 0 && s == 1) {return "martial_artist";}
        if (a == 0 && d == 1 && m == 1 && s == 0) {return "cleric";}
        if (a == 0 && d == 1 && m == 0 && s == 1) {return "escapist";}
        if (a == 0 && d == 0 && m == 1 && s == 1) {return "expediter";}
        if (a == 2 && d == 0 && m == 0 && s == 0) {return "slayer";}
        if (a == 0 && d == 2 && m == 0 && s == 0) {return "defender";}
        if (a == 0 && d == 0 && m == 2 && s == 0) {return "magician";}
        if (a == 0 && d == 0 && m == 0 && s == 2) {return "guerrilla";}
        else return "villager";
    }

    private static int fa = 0;
    private static int fd = 0;
    private static int fm = 0;
    private static int fs = 0;

    private static int BaseHP = getCharacterClass(fa, fd, fm, fs)[0]; // Error here, don't mind it.
    private static int BaseAtk = villager[1];
    private static int BaseDef = villager[2];
    private static int BaseMag = villager[3];
    private static int BaseSpd = villager[4];

    private static int HpIV = 0; // Will be random ans static from the start of the game onward
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
        setAllStats();
        System.out.println("Hp = " + Hp);
        System.out.println("Atk = " + Atk);
        System.out.println("Def = " + Def);
        System.out.println("Mag = " + Mag);
        System.out.println("Spd = " + Spd);

    }

}
