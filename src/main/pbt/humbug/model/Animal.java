package main.pbt.humbug.model;

public abstract class Animal {
    private Position positionOnBoard;
    private boolean onStar;

    public Animal(Position positionOnBoard) {
        this.onStar = false;
        this.positionOnBoard = positionOnBoard;
    }

    public abstract Position move(Board board, Direction direction, Animal... animals);

    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public boolean isOnStar() {
        return onStar;
    }

    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }
}
