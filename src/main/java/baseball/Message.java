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
        final List<HintStatus> hints = hintMessageOrder();
        String hintMessage = "";
        for (HintStatus hint : hints) {
            hintMessage += score.get(hint) + hint.getName() + " ";
        }
        return hintMessage.trim();
    }

    private List<HintStatus> hintMessageOrder() {
        return Arrays.asList(HintStatus.BALL, HintStatus.STRIKE);
    }
}
