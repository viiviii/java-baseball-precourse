package baseball;

import static baseball.Score.BALL;
import static baseball.Score.NOTHING;
import static baseball.Score.STRIKE;

public final class Scorer {

    public Score scoreTo(Ball ball, Ball other) {
        if (isStrike(ball, other)) {
            return STRIKE;
        }
        if (isBall(ball, other)) {
            return BALL;
        }
        return NOTHING;
    }

    public boolean isStrike(Ball ball, Ball other) {
        return ball.equals(other);
    }

    public boolean isBall(Ball ball, Ball other) {
        return !ball.equals(other) && ball.hasSameNumber(other);
    }
}
