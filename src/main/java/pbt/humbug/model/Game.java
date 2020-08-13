package pbt.humbug.model;

import java.util.Arrays;

public class Game implements Model {

    private Board board;
    private Animal[] animals;

    @Override
    public void startLevel(int level) {
        this.animals = new Animal[]{new Snail(new Position(0, 0))};
        this.board = Board.getInitialBoard();
    }

    @Override
    public boolean levelIsOver() {
        return Arrays.stream(this.getAnimals()).allMatch(Animal::isOnStar);
    }

    @Override
    public void move(Position position, Direction direction) {
        Arrays.stream(animals)
                .filter(animal -> animal.getPositionOnBoard().equals(position))
                .findFirst()
                .ifPresent(animal -> animal.move(board, direction, animals));
    }

    @Override
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }
}
