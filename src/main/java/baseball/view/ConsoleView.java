package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {

    @Override
    public String input() {
        return Console.readLine();
    }

    @Override
    public void output(String message) {
        System.out.println(message);
    }
}
