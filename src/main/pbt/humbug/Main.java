package main.pbt.humbug;

import main.pbt.humbug.controller.Controller;
import main.pbt.humbug.model.Game;
import main.pbt.humbug.model.view.text.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
