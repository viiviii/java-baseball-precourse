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
            return hintName(NOTHING);
        }
        final List<Hint> hints = sortedOutputHints();
        String message = "";
        for (Hint hint : hints) {
            message += score.get(hint) + hintName(hint) + " ";
        }
        return message.trim();
    }

    private List<Hint> sortedOutputHints() {
        return Arrays.asList(BALL, STRIKE);
    }

    public String hintName(Hint hint) {
        String name = "";
        switch (hint) {
            case STRIKE:
                name = "스트라이크";
                break;
            case BALL:
                name = "볼";
                break;
            case NOTHING:
                name = "낫싱";
                break;
        }
        return name;
    }
}
