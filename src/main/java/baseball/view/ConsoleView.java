package baseball.view;

import baseball.model.Hint;
import baseball.model.Score;
import baseball.view.message.Message;
import camp.nextstep.edu.missionutils.Console;

import static baseball.model.Hint.*;

public class ConsoleView implements View {
    private final Message message;

    public ConsoleView(Message message) {
        this.message = message;
    }

    @Override
    public String inputBalls() {
        System.out.print(message.inputBalls());
        return input();
    }

    @Override
    public String inputContinueNewGame() {
        return input();
    }

    private String input() {
        return Console.readLine();
    }

    @Override
    public void outputWinMessage() {
        output(message.win());
    }

    @Override
    public void outputContinueNewGameMessage() {
        output(message.continueNewGame());
    }

    @Override
    public void outputScoreMessage(Score score) {
        output(scoreMessage(score));
    }

    private void output(String message) {
        System.out.println(message);
    }

    String scoreMessage(Score score) {
        if (score.isNothing()) {
            return hintName(NOTHING);
        }
        return hintMessageWith(score);
    }

    private String hintName(Hint hint) {
        return message.hintName(hint);
    }

    private String hintMessageWith(Score score) {
        final StringBuilder msg = new StringBuilder();
        msg.append(hintMessage(score.getBall(), hintName(BALL)));
        msg.append(hintMessage(score.getStrike(), hintName(STRIKE)));
        return msg.toString().trim();
    }

    private String hintMessage(int count, String hintName) {
        if (count == 0) {
            return "";
        }
        return String.format("%d%s ", count, hintName);
    }
}
