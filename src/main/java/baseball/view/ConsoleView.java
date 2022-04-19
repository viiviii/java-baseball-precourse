package baseball.view;

import baseball.model.Hint;
import baseball.model.Score;
import baseball.view.message.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static baseball.model.Hint.*;

public class ConsoleView implements View {
    private final List<Hint> hintMessageOrder = Arrays.asList(BALL, STRIKE);
    private final Message message;


    public ConsoleView(Message message) {
        this.message = message;
    }

    @Override
    public String inputGameNumber() {
        System.out.print(message.inputGameNumbers());
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
        if (score.isAllNothing()) {
            return hintName(NOTHING);
        }
        return makeOrderedHintMessageWith(score);
    }

    private String hintName(Hint hint) {
        return message.hintName(hint);
    }

    private String makeOrderedHintMessageWith(Score score) {
        final StringBuilder msg = new StringBuilder();
        for (Hint hint : hintMessageOrder) {
            msg.append(hintMessage(score.getCount(hint), hintName(hint)));
        }
        return msg.toString().trim();
    }

    private String hintMessage(int count, String hintName) {
        if (count == 0) {
            return "";
        }
        return String.format("%d%s ", count, hintName);
    }
}
