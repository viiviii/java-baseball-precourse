package baseball.view;

import baseball.Hint;
import baseball.score.Score;
import baseball.view.message.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.Hint.*;

public class ConsoleView implements View {

    private final List<Hint> hintMessageOrder = Arrays.asList(BALL, STRIKE);
    private final Message message;


    public ConsoleView(Message message) {
        this.message = message;
    }

    @Override
    public String input() {
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
        if (score.isAllNothing()) {
            return hintName(NOTHING);
        }
        String msg = "";
        for (Hint hint : hintMessageOrder) {
            msg += hintMessage(score.getCount(hint), hintName(hint));
            msg += " ";
        }
        return msg.trim();
    }

    private String hintName(Hint hint) {
        return message.hintName(hint);
    }

    private String hintMessage(int count, String hintName) {
        if (count == 0) {
            return "";
        }
        return String.format("%d%s", count, hintName);
    }
}
