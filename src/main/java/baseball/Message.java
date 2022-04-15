package baseball;

import baseball.score.Score;

import java.util.Arrays;
import java.util.List;

public class Message {

    private final Score score;

    public Message(Score score) {
        this.score = score;
    }

    public String toHint() {
        if (score.isNothing()) {
            return HintStatus.NOTHING.getName();
        }
        final List<HintStatus> hints = sortedOutputHints();
        String message = "";
        for (HintStatus hint : hints) {
            message += score.get(hint) + hint.getName() + " ";
        }
        return message.trim();
    }

    private List<HintStatus> sortedOutputHints() {
        return Arrays.asList(HintStatus.BALL, HintStatus.STRIKE);
    }
}
