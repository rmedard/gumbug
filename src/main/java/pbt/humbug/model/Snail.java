package pbt.humbug.model;

public class Snail extends Animal {
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position newPosition = new Position(getPositionOnBoard().getRow() + direction.getDeltaRow(),
                getPositionOnBoard().getColumn() + direction.getDeltaColumn());
        if (!board.isInside(newPosition)) {
            this.setPositionOnBoard(null);
            return null;
        }
        for (Animal animal : animals) {
            if (!animal.equals(this) && animal.getPositionOnBoard().equals(newPosition) && !animal.isOnStar()) {
                return this.getPositionOnBoard();
            }
        }
        if (board.getSquares()[newPosition.getRow()][newPosition.getColumn()].getSquareType().equals(SquareType.STAR)) {
            this.setOnStar(true);
            board.getSquares()[newPosition.getRow()][newPosition.getColumn()] = new Square(SquareType.GRASS);
        }
        this.setPositionOnBoard(newPosition);
        return newPosition;
    }
}
