package pbt.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it's all.
 * A square doesn't know where it is on the board
 */
public class Square {
    private SquareType squareType;
    private boolean northWall;
    private boolean southWall;
    private boolean westWall;
    private boolean eastWall;

    /**
     * Constructor of Square on board
     * @param squareType Square is grass or star
     */
    public Square(SquareType squareType) {
        this.squareType = squareType;
        northWall = false;
        southWall = false;
        eastWall = false;
        westWall = false;
    }

    public boolean hasWall(Direction direction) {
        return false;
    }

    /**
     * Simple getter of type
     * @return type os Square
     */
    public SquareType getSquareType() {
        return squareType;
    }

    public void setSquareType(SquareType squareType) {
        this.squareType = squareType;
    }

    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }
}
