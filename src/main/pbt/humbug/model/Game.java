package main.pbt.humbug.model;

import java.util.Arrays;

public class Game implements Model {
    @Override
    public Board getBoard() {
        return Board.getInitialBoard();
    }

    @Override
    public Animal[] getAnimals() {
        return new Animal[]{new Snail(new Position(0, 0))};
    }

    @Override
    public void startLevel(int level) {

    }

    @Override
    public boolean levelIsOver() {
        return Arrays.stream(this.getAnimals()).allMatch(Animal::isOnStar);
    }

    @Override
    public void move(Position position, Direction direction) {

    }
}
