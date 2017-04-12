public interface BasesGalore {

    // ATK, DEF, MAG, SPD

    int VILLAGER = 0; // 0000

    int FIGHTER = 1; // 1000
    int GUARD = 2; // 0100
    int SPELLCASTER = 3; // 0010
    int ATHLETE = 4; // 0001

    int KNIGHT = 5; // 1100
    int SPELLSWORD = 6; // 1010
    int MARTIALARTIST = 7; // 1001
    int CLERIC = 8; // 0110
    int ESCAPIST = 9; // 0101
    int EXPEDITER = 10; // 0011
    int SLAYER = 11; // 2000
    int DEFENDER = 12; // 0200
    int MAGICIAN = 13; // 0020
    int GUERRILLA = 14; // 0002

    int PALADIN = 15; // 1110
    int ARCHER = 16; // 1011
    int CAVALIER = 17; // 1101
    int MONK = 18; // 0111
    int DEATHBRINGER = 19; // 3000
    int IRONSIDE = 20; // 0300
    int ELEMANCER = 21; // 0030
    int VELOXLUX = 22; // 0003 Dat name doh
    int GLADIATOR = 23; // 2100
    int SOULEATER = 24; // 2010
    int ASSASSIN = 25; // 2001
    int SAMURAI = 26; // 1200
    int SHELLCASTER = 27; // 0210
    int ARMADILLO = 28; // 0201
    int NECROMANCER = 29; // 1020
    int DIVINER = 30; // 0120
    int CONJUROR = 31; // 0021
    int SPY = 32; // 0102
    int DRAGOON = 33; // 1002
    int TIMEMAGE = 34; // 0012


    // The comments here signify the average stats for each class. 40 for Class 0, 51-53 for Class 1, 68-72 for Class 2, TBD (90?) for Class 3.
    BaseCharacter[] characters = {
            new BaseCharacter("Villager", 40, 40,40, 40,40), // 40

            new BaseCharacter("Fighter", 65, 70, 50, 35, 35), // 51
            new BaseCharacter("Guard", 80, 50, 80, 20, 40), // 53
            new BaseCharacter("Spellcaster", 60, 20, 15, 105, 60), // 53
            new BaseCharacter("Athlete", 65, 50, 50, 20, 80), // 52

            new BaseCharacter("Knight", 90, 85, 85, 35, 45), // 69
            new BaseCharacter("Spellsword", 75, 75, 30, 130, 45), // 71
            new BaseCharacter("Martial Artist", 80, 85, 60, 40, 90), // 71
            new BaseCharacter("Cleric", 90, 30, 75, 110, 40), // 69
            new BaseCharacter("Escapist", 85, 45, 85, 35, 90), // 68
            new BaseCharacter("Expediter", 70, 60, 85, 100, 45), // 72
            new BaseCharacter("Slayer", 65, 120, 65, 35, 65), // 70
            new BaseCharacter("Defender", 115, 70, 120, 25, 30), // 72
            new BaseCharacter("Magician", 65, 55, 40, 150, 40), // 71
            new BaseCharacter("Guerrilla", 85, 80, 65, 15, 110), // 71

            new BaseCharacter("Paladin", 110, 80, 65, 15, 110), //
            new BaseCharacter("Archer", 90, 80, 65, 15, 110), //
            new BaseCharacter("Cavalier", 100, 80, 65, 15, 110), //
            new BaseCharacter("Monk", 85, 80, 65, 15, 110), //
            new BaseCharacter("Deathbringer", 100, 150, 65, 15, 50), // 76
            new BaseCharacter("Ironside", 130, 80, 150, 10, 25), // 79
            new BaseCharacter("Elemancer", 90, 40, 55, 140, 50), //
            new BaseCharacter("Veloxlux", 100, 70, 70, 50, 200), //
            new BaseCharacter("Gladiator", 115, 120, 150, 10, 25), //
            new BaseCharacter("Soul Eater", 115, 120, 150, 10, 25), //
            new BaseCharacter("Assassin", 115, 120, 150, 10, 25), //
            new BaseCharacter("Samurai", 115, 120, 150, 10, 25), //
            new BaseCharacter("Shellcaster", 115, 120, 150, 10, 25), //
            new BaseCharacter("Armadillo", 115, 120, 150, 10, 25), //
            new BaseCharacter("Gladiator", 115, 120, 150, 10, 25)
    };
}
