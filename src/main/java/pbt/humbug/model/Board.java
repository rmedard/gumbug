package pbt.humbug.model;

public class Board {
    private final Square[][] squares;

    Board(Square[][] squares) {
        this.squares = squares;
    }

    public static Board getInitialBoard() {
        Square[][] squares =
                {
                        {new Square(SquareType.GRASS), new Square(SquareType.GRASS), null},
                        {null, new Square(SquareType.GRASS), new Square(SquareType.GRASS)},
                        {null, null, new Square(SquareType.STAR)}
                };
        return new Board(squares);
    }

    public boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }

        return ((position.getRow() >= 0 && position.getColumn() >= 0)
                && (position.getRow() <= this.getNbRow() - 1 && position.getColumn() <= this.getNbColumn() - 1)
                && this.squares[position.getRow()][position.getColumn()] != null);
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

    public SquareType getSquareType(Position position) {
        if (position == null || this.squares[position.getRow()][position.getColumn()] == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        return this.squares[position.getRow()][position.getColumn()].getSquareType();
    }
}
