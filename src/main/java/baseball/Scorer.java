package baseball;

import static baseball.Score.BALL;
import static baseball.Score.NOTHING;
import static baseball.Score.STRIKE;

import java.util.List;

public final class Scorer {

    public Score scoreTo(List<Ball> balls, Ball other) {
        if (isStrike(balls, other)) {
            return STRIKE;
        }
        if (isBall(balls, other)) {
            return BALL;
        }
        return NOTHING;
    }

    public boolean isStrike(List<Ball> balls, Ball other) {
        return balls.contains(other);
    }

    public boolean isBall(List<Ball> balls, Ball other) {
        return !isStrike(balls, other) && hasSameNumber(balls, other);
    }

    public boolean hasSameNumber(List<Ball> balls, Ball other) {
        for (Ball ball : balls) {
            if (ball.hasSameNumber(other)) {
                return true;
            }
        }
        return false;
    }
}
