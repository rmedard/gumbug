package pbt.humbug.model;

public class Spider extends Animal {
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return null;
    }
}
