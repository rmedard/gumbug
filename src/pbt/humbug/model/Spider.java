package pbt.humbug.model;

import javafx.geometry.Pos;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Spider extends Animal {
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        List<Animal> otherAnimals = stream(animals).filter(animal -> !animal.equals(this)).collect(toList());
        Position nextPosition = nextPosition(this.getPositionOnBoard(), board, direction, otherAnimals);
        Square newPositionSquare = board.getSquares()[nextPosition.getRow()][nextPosition.getColumn()];
        if (newPositionSquare.getSquareType().equals(SquareType.STAR)) {
            this.setOnStar(true);
            newPositionSquare = new Square(SquareType.GRASS);
        }
        return nextPosition;
    }

    private Position nextPosition(Position fromPosition, Board board, Direction direction, List<Animal> animals) {
        Position nextPosition = new Position(fromPosition.getRow() + direction.getDeltaRow(),
                fromPosition.getColumn() + direction.getDeltaColumn());
        if (!board.isInside(nextPosition)) {
            return fromPosition;
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(nextPosition) && !animal.isOnStar()) {
                return fromPosition;
            }
        }
        return nextPosition(nextPosition, board, direction, animals);
    }
}
