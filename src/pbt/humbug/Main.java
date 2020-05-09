package pbt.humbug;

import pbt.humbug.controller.Controller;
import pbt.humbug.model.Game;
import pbt.humbug.model.view.text.View;

public class Main {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
//        System.out.println("test ....");
//        System.out.println(ANSI_GREEN_BACKGROUND + "This text is green" + ANSI_RESET);

        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
