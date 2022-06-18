package baseball.domain;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.NOTHING;
import static baseball.domain.Score.STRIKE;

import java.util.ArrayList;
import java.util.List;

public final class Scorer {

    public List<Score> totalScoreTo(Balls balls, Balls otherBalls) {
        final List<Score> scores = new ArrayList<>();
        for (Ball otherBall : otherBalls.toList()) {
            final Score score = scoreTo(balls, otherBall);
            scores.add(score);
        }
        return scores;
    }

    public Score scoreTo(Balls balls, Ball other) {
        if (isStrike(balls, other)) {
            return STRIKE;
        }
        if (isBall(balls, other)) {
            return BALL;
        }
        return NOTHING;
    }

    public boolean isStrike(Balls balls, Ball other) {
        return balls.hasSameBall(other);
    }

    public boolean isBall(Balls balls, Ball other) {
        return !balls.hasSameBall(other) && balls.hasSameNumber(other);
    }
}
