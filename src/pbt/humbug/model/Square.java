package pbt.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it's all.
 * A square doesn't know where it is on the board
 */
public class Square {
    private SquareType squareType;

    /**
     * Constructor of Square on board
     * @param squareType Square is grass or star
     */
    public Square(SquareType squareType) {
        this.squareType = squareType;
    }

    /**
     * Simple getter of type
     * @return type os Square
     */
    public SquareType getSquareType() {
        return squareType;
    }
}
