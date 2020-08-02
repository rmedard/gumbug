package main.pbt.humbug.controller;

import main.pbt.humbug.model.Board;
import main.pbt.humbug.model.Direction;
import main.pbt.humbug.model.Model;
import main.pbt.humbug.model.Position;
import main.pbt.humbug.model.view.text.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        view.displayBoard(Board.getInitialBoard());
        Position position = view.askPosition();
        Direction direction = view.askDirection();

    }
}
