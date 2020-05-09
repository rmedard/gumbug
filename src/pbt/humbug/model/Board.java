package pbt.humbug.model;

import static pbt.humbug.model.SquareType.GRASS;
import static pbt.humbug.model.SquareType.STAR;

public class Board {
    private Square[][] squares;

    Board(Square[][] squares) {
        this.squares = squares;
    }

    public static Board getInitialBoard() {
        Square[][] squares =
                {
                        {new Square(GRASS), new Square(GRASS), null},
                        {null, new Square(GRASS), new Square(GRASS)},
                        {null, null, new Square(STAR)}
                };
        return new Board(squares);
    }

    public boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        return this.squares[position.getRow()][position.getColumn()] != null;
    }

    public int getNbRow() {
        return this.squares.length;
    }

    public int getNbColumn() {
        return this.squares[0].length;
    }

    public Square[][] getSquares() {
        return squares;
    }
}
