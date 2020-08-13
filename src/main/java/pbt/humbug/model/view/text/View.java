package pbt.humbug.model.view.text;


import pbt.humbug.model.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class View implements InterfaceView {

    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void displayBoard(Board board, Animal... animals) {
        StringBuilder display = new StringBuilder();
        for (int rowIndex = 0; rowIndex < board.getNbRow(); rowIndex++) {
            if (rowIndex == 0)
                drawHeaders(display, board.getSquares()[0]);
            display.append("\n");
            drawWallsAndAnimals(display, board.getSquares()[rowIndex], animals, rowIndex);
            display.append("\n");
            drawSoils(display, rowIndex, board);
        }
        System.out.println(display);
    }

    public void displayError(String message) {
        System.err.println("\nError: " + message);
    }

    public Position askPosition() {
        Scanner scanner = new Scanner(System.in);
        int positionRow;
        int positionColumn;
        do {
            System.out.print("Enter Position Row: ");
            while (!scanner.hasNextInt()) {
                displayError("Please enter a valid row number");
                scanner.next();
            }
            positionRow = scanner.nextInt();
            if (positionRow < 0) {
                displayError("Please enter a row number equal or greater than 0");
            }
        } while (positionRow < 0);

        do {
            System.out.print("Enter Position Column: ");
            while (!scanner.hasNextInt()) {
                displayError("Please enter a valid column number");
                scanner.next();
            }
            positionColumn = scanner.nextInt();
            if (positionColumn < 0) {
                displayError("Please enter a column number equal or greater than 0");
            }
        } while (positionColumn < 0);
        return new Position(positionRow, positionColumn);
    }

    public Direction askDirection() {
        Scanner scanner = new Scanner(System.in);
        Direction direction = null;
        do {
            System.out.print("Enter Direction: 'N' for (North), 'S' for (South), 'E' for (East), 'W' for (West): ");
            String directionStr = scanner.nextLine().toUpperCase();
            switch (directionStr) {
                case "N":
                    direction = Direction.NORTH;
                    break;
                case "S":
                    direction = Direction.SOUTH;
                    break;
                case "E":
                    direction = Direction.EAST;
                    break;
                case "W":
                    direction = Direction.WEST;
                    break;
                default:
                    displayError("Please enter a valid direction (N, S, E, W)");
                    break;
            }
        } while (direction == null);
        return direction;
    }

    private void drawHeaders(StringBuilder display, Square[] row) {
        for (Square square : row) {
            if (square != null) {
                display.append(ANSI_GREEN_BACKGROUND);
                display.append("\u2500\u2500\u2500\u2500");
                display.append(ANSI_RESET);
            } else {
                display.append("    ");
            }
        }
    }

    private void drawWallsAndAnimals(StringBuilder display, Square[] row, Animal[] animals, int rowIndex) {
        StringBuilder bricks = new StringBuilder();
        final String ANIMAL = ANSI_WHITE + "S" + ANSI_RESET + ANSI_GREEN_BACKGROUND;
        final String STAR = ANSI_RED + "*" + ANSI_RESET + ANSI_GREEN_BACKGROUND;
        for (int brickLevel = 1; brickLevel <= 3; brickLevel++) {
            for (int column = 0; column < row.length; column++) {
                Square square = row[column];
                if (square != null) {
                    bricks.append(ANSI_GREEN_BACKGROUND);
                    bricks.append("\u2502");
                    if (brickLevel != 2) {
                        bricks.append("\t");
                    } else {
                        if (square.getSquareType().equals(SquareType.STAR)) {
                            bricks.append(" " + STAR + " ");
                        } else {
                            int finalColumn = column;
                            Optional<Animal> animalOnSquare =  Arrays.stream(animals)
                                    .filter(animal -> animal.getPositionOnBoard() != null
                                            && animal.getPositionOnBoard().getRow() == rowIndex
                                            && animal.getPositionOnBoard().getColumn() == finalColumn)
                                    .findFirst();
                            if (animalOnSquare.isPresent()) {
                                bricks.append(" " + ANIMAL + " ");
                            } else {
                                bricks.append("   ");
                            }
                        }
                    }
                    if (column == row.length - 1 || row[column + 1] == null) {
                        bricks.append("\u2502");
                    }
                    bricks.append(ANSI_RESET);
                } else {
                    bricks.append("\t");
                }
            }
            if (brickLevel < 3) bricks.append("\n");
        }
        display.append(bricks);
    }

    private void drawSoils(StringBuilder display, int rowIndex, Board board) {
        Square[] row = board.getSquares()[rowIndex];
        for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
            Square square = row[columnIndex];
            if (square != null) {
                display.append(ANSI_GREEN_BACKGROUND);
                display.append("-----");
                display.append(ANSI_RESET);
            } else {
                display.append("\t");
            }
            if (rowIndex < board.getSquares().length - 1 && columnIndex < row.length - 1 &&
                    board.getSquares()[rowIndex + 1][columnIndex + 1] != null &&
                    board.getSquares()[rowIndex][columnIndex + 1] == null) {
                display.append(ANSI_GREEN_BACKGROUND);
                display.append("----");
                display.append(ANSI_RESET);
            }
        }
    }
}
