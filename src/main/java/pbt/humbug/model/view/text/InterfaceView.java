package pbt.humbug.model.view.text;


import pbt.humbug.model.Animal;
import pbt.humbug.model.Board;
import pbt.humbug.model.Direction;
import pbt.humbug.model.Position;

public interface InterfaceView {
    void displayBoard(Board board, Animal... animals);
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
}
