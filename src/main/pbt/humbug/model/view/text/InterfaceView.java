package main.pbt.humbug.model.view.text;

import main.pbt.humbug.model.Animal;
import main.pbt.humbug.model.Board;
import main.pbt.humbug.model.Direction;
import main.pbt.humbug.model.Position;

public interface InterfaceView {
    void displayBoard(Board board, Animal... animals);
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
}
