package baseball.player;

import baseball.GameNumbers;
import baseball.Parser;
import baseball.io.Controller;

import java.util.List;

public final class Guessers {

    private final Controller controller;

    public Guessers(Controller controller) {
        this.controller = controller;
    }

    public GameNumbers guess() {
        final String input = controller.input();
        final List<Integer> numbers = Parser.parseIntegerList(input); // TODO
        return new GameNumbers(numbers);
    }
}
