package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleController implements Controller {

    @Override
    public String input() {
        return Console.readLine();
    }
}
