public interface Monsters {
    int SLIME = 0;
    int BAT = 1;
    int ZOMBIE = 2;

    BaseMonster[] monsters = {
            new BaseMonster("Slime", 30, 5, 2, 10),
            new BaseMonster("Bat", 20, 10, 2, 30),
            new BaseMonster("Zombie", 60, 7, 5, 5)
    };
}