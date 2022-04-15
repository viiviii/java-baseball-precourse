package baseball;

import baseball.score.Score;

import java.util.Arrays;
import java.util.List;

import static baseball.Hint.*;

public class Message {

    private final Score score;

    public Message(Score score) {
        this.score = score;
    }

    public String toHint() {
        if (score.isNothing()) {
            return NOTHING.getName();
        }
        final List<Hint> hints = sortedOutputHints();
        String message = "";
        for (Hint hint : hints) {
            message += score.get(hint) + hint.getName() + " ";
        }
        return message.trim();
    }

    private List<Hint> sortedOutputHints() {
        return Arrays.asList(BALL, STRIKE);
    }
}
