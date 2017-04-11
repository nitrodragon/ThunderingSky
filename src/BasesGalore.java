/**
 * Created by nitrodragon on 4/9/2017.
 */
public interface BasesGalore {

    static final int VILLAGER = 0;
    static final int FIGHTER = 1;
    static final int GUARD = 2;
    static final int SPELLCASTER = 3;
    static final int ATHLETE = 4;
    static final int KNIGHT = 5;
    static final int SPELLSWORD = 6;
    static final int MARTIALARTIST = 7;
    static final int CLERIC = 8;
    static final int ESCAPIST = 9;
    static final int EXPEDITER = 10;
    static final int MERCENARY = 11;
    static final int DEFENDER = 12;
    static final int MAGICIAN = 13;
    static final int GUERRILLA = 14;


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
