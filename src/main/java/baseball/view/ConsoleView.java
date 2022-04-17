package baseball.view;

import baseball.view.message.Message;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {

    private final Message message;

    public ConsoleView(Message message) {
        this.message = message;
    }

    @Override
    public String input() {
        return Console.readLine();
    }

    @Override
    public void outputScoreMessage(String score) {
        output(score);
    }

    @Override
    public void outputWinMessage() {
        output(message.win());
    }

    @Override
    public void outputContinueNewGameMessage() {
        output(message.continueNewGame());
    }

    private void output(String message) {
        System.out.println(message);
    }
}
