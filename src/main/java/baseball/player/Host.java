package baseball.player;

import baseball.GameNumbers;
import baseball.Parser;
import baseball.io.Controller;

import java.util.List;

public class Host {

    private final Controller controller;

    public Host(Controller controller) {
        this.controller = controller;
    }

    public GameNumbers think() {
        final String input = controller.input();
        final List<Integer> numbers = Parser.parseIntegerList(input); // TODO
        return new GameNumbers(numbers);
    }
}
