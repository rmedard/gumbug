package pbt.humbug.model;

public class Direction {
    private int deltaRow;
    private int deltaColumn;

    public final static Direction NORTH = new Direction(-1, 0);
    public final static Direction SOUTH = new Direction(1, 0);
    public final static Direction EAST = new Direction(0, 1);
    public final static Direction WEST = new Direction(0, -1);

    public Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    public Direction opposite() {
        if (this.equals(NORTH) || this.equals(SOUTH)) {
            return this.equals(NORTH) ? SOUTH : NORTH;
        } else {
            return this.equals(WEST) ? EAST : WEST;
        }
    }

    public int getDeltaRow() {
        return deltaRow;
    }

    public int getDeltaColumn() {
        return deltaColumn;
    }

    @Override
    public String toString() {
        String direction = "Direction: ";
        if (this.equals(NORTH)) {
            direction += "NORTH";
        } else if (this.equals(SOUTH)) {
            direction += "SOUTH";
        } else if (this.equals(EAST)) {
            direction += "EAST";
        } else if (this.equals(WEST)) {
            direction += "WEST";
        }
        return direction;
    }
}
