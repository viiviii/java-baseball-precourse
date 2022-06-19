package baseball.domain;

import static baseball.domain.Score.BALL;
import static baseball.domain.Score.NOTHING;
import static baseball.domain.Score.STRIKE;

import java.util.ArrayList;
import java.util.List;

public final class Umpire {

    public Scores call(Balls balls, Balls otherBalls) {
        final ScoreRecord scoreRecord = new ScoreRecord();
        for (Ball otherBall : otherBalls.toList()) {
            final Score score = call(balls, otherBall);
            scoreRecord.add(score);
        }
        return scoreRecord.toScore();
    }

    private Score call(Balls balls, Ball oneBall) {
        if (isStrike(balls, oneBall)) {
            return STRIKE;
        }
        if (isBall(balls, oneBall)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean isStrike(Balls balls, Ball oneBall) {
        return balls.hasSameBall(oneBall);
    }

    private boolean isBall(Balls balls, Ball oneBall) {
        return !balls.hasSameBall(oneBall) && balls.hasSameNumber(oneBall);
    }

    // TODO
    private static final class ScoreRecord {
        private final List<Score> record = new ArrayList<>();

        private void add(Score score) {
            record.add(score);
        }

        private int countStrike() {
            final List<Score> strikes = new ArrayList<>(record);
            strikes.removeIf(score -> !score.equals(STRIKE));
            return strikes.size();
        }

        private int countBall() {
            final List<Score> balls = new ArrayList<>(record);
            balls.removeIf(score -> !score.equals(BALL));
            return balls.size();
        }

        private Scores toScore() {
            return new Scores(countStrike(), countBall());
        }
    }
}
