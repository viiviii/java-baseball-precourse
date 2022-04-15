package baseball;

import baseball.score.Score;

import java.util.Arrays;
import java.util.List;

import static baseball.Hint.*;

public class Message {

    private final List<Hint> sortedOutputHints = Arrays.asList(BALL, STRIKE);

    public String toHint(Score score) {
        if (score.isNothing()) {
            return hintName(NOTHING);
        }
        String message = "";
        for (Hint hint : sortedOutputHints) {
            final int count = score.get(hint);
            final String name = hintName(hint);
            message += hint(count, name);
        }
        return message.trim();
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

    private String hint(int count, String name) {
        return String.format("%d%s ", count, name);
    }
}
