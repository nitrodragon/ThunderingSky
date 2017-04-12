interface Monsters {
    int SLIME = 0;
    int BAT = 1;
    int ZOMBIE = 2;
    int WRATH = 3;

    BaseMonster[] monsters = {
            // So, are we gonna have a static HP for the Monsters? No calculation. That could work. I have a damage formula, so we'll have to put that in here soon.
            new BaseMonster("Slime", 30, 5, 2, 10, 1),
            new BaseMonster("Bat", 20, 10, 2, 30, 1),
            new BaseMonster("Zombie", 60, 7, 5, 5, 2),
            new BaseMonster("Wrath", 400, 100, 30, 60, 3) // Need 200 def to avoid attack
    };
}
