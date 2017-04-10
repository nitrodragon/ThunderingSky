/**
 * Created by nitrodragon on 4/9/2017.
 */
public interface BasesGalore {

    String[] classes = {
            "villager", // 0-0-0-0 (base class)
            "fighter", "guard", "spellcaster", "athlete", // 1 stat point
            "knight", "spellsword", "martial_artist", "cleric", "escapist", "expediter", "slayer", "defender", "magician", "guerrilla" // 2 stat points
    };

    static final BaseCharacter[] characters = {
            new BaseCharacter("villager", 50, 50, 50, 50, 50),
            new BaseCharacter("fighter", 60, 70, 50, 35, 35),
            new BaseCharacter("guard", 80, 50, 80, 20, 40),
            new BaseCharacter("spellcaster", 65, 20, 15, 105, 60),
            new BaseCharacter("athlete", 65, 50, 50, 20, 80),
            new BaseCharacter("knight", 80, 70, 50, 35, 35),


    };
}
