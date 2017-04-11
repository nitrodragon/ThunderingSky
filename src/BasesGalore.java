/**
 * Created by nitrodragon on 4/9/2017.
 */
public interface BasesGalore {

    static final int VILLAGER = 0; // 0000
    static final int FIGHTER = 1; // 1000
    static final int GUARD = 2; // 0100
    static final int SPELLCASTER = 3; // 0010
    static final int ATHLETE = 4; // 0001
    static final int KNIGHT = 5; // 1100
    static final int SPELLSWORD = 6; // 1010
    static final int MARTIALARTIST = 7; // 1001
    static final int CLERIC = 8; // 0110
    static final int ESCAPIST = 9; // 0101
    static final int EXPEDITER = 10; // 0011
    static final int MERCENARY = 11; // 2000
    static final int DEFENDER = 12; // 0200
    static final int MAGICIAN = 13; // 0020
    static final int GUERRILLA = 14; // 0002
    static final int PALADIN = 15; // 1110
    static final int MONK = 16; // 1011
    static final int CAVALIER = 17; // 1101
    static final int SAMURAI = 18; // 1200
    static final int SHELLCASTER = 19; // 0210
    static final int ARMADILLO = 20; // 0201
    static final int NECROMANCER = 21; // 1020
    static final int DIVINER = 22; // 0120
    static final int CONJUROR = 23; // 0021
    static final int SPY = 24; // 0102
    static final int DRAGOON = 25; // 1002
    static final int TIMEMAGE = 26; // 0012
    static final int DEATHBRINGER = 27; // 3000
    static final int IRONSIDE = 28; // 0300
    static final int ELEMANCER = 29; // 0030
    static final int VELOXLUX = 30; // 0003
    static final int GLADIATOR = 31; // 2100
    static final int SOULEATER = 32; // 2010
    static final int ASSASSIN = 33; // 2001


    // The comments here signify the average stats for each class. 40 for Class 0, 51-53 for Class 1, 68-72 for Class 2, TBD (90?) for Class 3.
    BaseCharacter[] characters = {
            new BaseCharacter("Villager", 40, 40,40, 40,40), // 40

            new BaseCharacter("Fighter", 65, 70, 50, 35, 35), // 51
            new BaseCharacter("Guard", 80, 50, 80, 20, 40), // 53
            new BaseCharacter("Spellcaster", 60, 20, 15, 105, 60), // 53
            new BaseCharacter("Athlete", 65, 50, 50, 20, 80), // 52

            new BaseCharacter("Knight", 90, 85, 85, 35, 45), // 69
            new BaseCharacter("Spellsword", 75, 75, 30, 130, 45), // 71
            new BaseCharacter("Martial_artist", 80, 85, 60, 40, 90), // 71
            new BaseCharacter("Cleric", 90, 30, 75, 110, 40), // 69
            new BaseCharacter("Escapist", 85, 45, 85, 35, 90), // 68
            new BaseCharacter("Expediter", 70, 60, 85, 100, 45), // 72
            new BaseCharacter("Slayer", 65, 120, 65, 35, 65), // 70
            new BaseCharacter("Defender", 115, 70, 120, 25, 30), // 72
            new BaseCharacter("Magician", 65, 55, 40, 150, 40), // 71
            new BaseCharacter("Guerrilla", 85, 80, 65, 15, 110), // 71

    };
}
