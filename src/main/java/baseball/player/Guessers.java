package baseball.player;

import baseball.GameNumbers;
import baseball.io.Controller;
import baseball.parser.Parser;

public final class Guessers {

    private final Controller controller;

    public Guessers(Controller controller) {
        this.controller = controller;
    }

    public GameNumbers guess() {
        final String input = controller.input();
        return Parser.asGameNumbers(input);
    }
}
