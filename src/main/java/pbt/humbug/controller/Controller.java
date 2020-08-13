package pbt.humbug.controller;

import pbt.humbug.model.Direction;
import pbt.humbug.model.Model;
import pbt.humbug.model.Position;
import pbt.humbug.model.view.text.InterfaceView;

import java.util.Arrays;

public class Controller {
    private Model game;
    private InterfaceView view;

    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    public void startGame() {
        game.startLevel(1);
        boolean noFallenAnimal = Arrays.stream(game.getAnimals())
                .noneMatch(animal -> animal.getPositionOnBoard() == null);
        while (!game.levelIsOver() && noFallenAnimal) {
            view.displayBoard(game.getBoard(), game.getAnimals());
            Position position = view.askPosition();
            Direction direction = view.askDirection();
            game.move(position, direction);
        }
        System.err.println("!!! GAME OVER !!!");
    }
}
