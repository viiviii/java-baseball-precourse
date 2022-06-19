package baseball.domain;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.NOTHING;
import static baseball.domain.Score.STRIKE;

import java.util.ArrayList;
import java.util.List;

public final class Umpire {

    public Scores call(Balls balls, Balls otherBalls) {
        final List<Score> scores = new ArrayList<>();
        for (Ball otherBall : otherBalls.toList()) {
            final Score score = call(balls, otherBall);
            scores.add(score);
        }
        return new Scores(countStrikeTo(scores), countBallTo(scores));
    }

    private Score call(Balls balls, Ball other) {
        if (isStrike(balls, other)) {
            return STRIKE;
        }
        if (isBall(balls, other)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean isStrike(Balls balls, Ball other) {
        return balls.hasSameBall(other);
    }

    private boolean isBall(Balls balls, Ball other) {
        return !balls.hasSameBall(other) && balls.hasSameNumber(other);
    }

    private int countStrikeTo(List<Score> scores) {
        final List<Score> strikes = new ArrayList<>(scores); // TODO
        strikes.removeIf(score -> !score.equals(STRIKE));
        return strikes.size();
    }

    private int countBallTo(List<Score> scores) {
        final List<Score> balls = new ArrayList<>(scores); // TODO
        balls.removeIf(score -> !score.equals(BALL));
        return balls.size();
    }
}
