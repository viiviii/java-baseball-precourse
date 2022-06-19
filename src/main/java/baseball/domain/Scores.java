package baseball.domain;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.STRIKE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public int strikeCount() {
        final List<Score> strikes = new ArrayList<>(value); // TODO
        strikes.removeIf(score -> !score.equals(STRIKE));
        return strikes.size();
    }

    public int ballCount() {
        final List<Score> balls = new ArrayList<>(value); // TODO
        balls.removeIf(score -> !score.equals(BALL));
        return balls.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Scores)) {
            return false;
        }
        Scores scores = (Scores) o;
        return Objects.equals(value, scores.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
