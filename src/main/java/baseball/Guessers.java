package baseball;

import baseball.io.Controller;

public final class Guessers {

    private final Controller controller;

    public Guessers(Controller controller) {
        this.controller = controller;
    }

    public String guess() {
        return controller.input();
    }
}
