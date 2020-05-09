package pbt.humbug.controller;

import pbt.humbug.model.Model;
import pbt.humbug.model.view.text.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {

    }
}
