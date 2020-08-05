package pbt.humbug;

import pbt.humbug.controller.Controller;
import pbt.humbug.model.Game;
import pbt.humbug.model.view.text.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
