package baseball.domain;

import static baseball.domain.Score.STRIKE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Scores {
    private final List<Score> value;

    private Scores(List<Score> value) {
        this.value = value;
    }

    public static Scores from(List<Score> score) {
        return new Scores(new ArrayList<>(score));
    }

    public static Scores of(Score... scores) {
        return new Scores(Arrays.asList(scores));
    }

    public boolean isPerfect() {
        final List<Score> strikes = new ArrayList<>(value); // TODO
        strikes.removeIf(score -> !score.equals(STRIKE));
        return strikes.size() == 3; // TODO
    }

    // TODO: 임시
    public List<Score> toList() {
        return new ArrayList<>(value);
    }
}
