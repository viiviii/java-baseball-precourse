package baseball.player;

import baseball.GameNumbers;
import baseball.io.Controller;
import baseball.parser.Parser;

public class Host {

    private final Controller controller;

    public Host(Controller controller) {
        this.controller = controller;
    }

    public GameNumbers think() {
        final String input = controller.input();
        return Parser.asGameNumbers(input);
    }
}
