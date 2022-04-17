package baseball.score;

import baseball.Hint;

public class Match {

    private final Hint hint;
    private final int points;

    public Match(Hint hint, int points) {
        this.hint = hint;
        this.points = points;
    }
}
