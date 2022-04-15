package baseball.player;

import baseball.io.Controller;

public class Host {

    private final Controller controller;

    public Host(Controller controller) {
        this.controller = controller;
    }

    public String think() {
        return controller.input();
    }
}
