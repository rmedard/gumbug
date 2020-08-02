package main.pbt.humbug.model;

public interface Model {
    Board getBoard();
    Animal[] getAnimals();
    void startLevel(int level);
    boolean levelIsOver();
    void move(Position position, Direction direction);
}
