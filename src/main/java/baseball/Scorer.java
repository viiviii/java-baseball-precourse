package baseball;

import static baseball.Score.BALL;
import static baseball.Score.NOTHING;
import static baseball.Score.STRIKE;

public final class Scorer {

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
