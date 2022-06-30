package baseball.gameStrategy;

import static baseball.gameStrategy.Match.BALL;
import static baseball.gameStrategy.Match.NOTHING;
import static baseball.gameStrategy.Match.STRIKE;

import baseball.gamePlay.Score;
import baseball.gamePlay.Umpire;
import java.util.ArrayList;
import java.util.List;

public final class UmpireImpl implements Umpire {

    @Override
    public Score call(Balls balls, Balls otherBalls) {
        final ScoreRecord scoreRecord = new ScoreRecord();
        for (Ball otherBall : otherBalls.toList()) {
            final Match score = call(balls, otherBall);
            scoreRecord.add(score);
        }
        return scoreRecord.toScore();
    }

    private Match call(Balls balls, Ball oneBall) {
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
        private final List<Match> record = new ArrayList<>();

        private void add(Match score) {
            record.add(score);
        }

        private int countStrike() {
            final List<Match> strikes = new ArrayList<>(record);
            strikes.removeIf(score -> !score.equals(STRIKE));
            return strikes.size();
        }

        private int countBall() {
            final List<Match> balls = new ArrayList<>(record);
            balls.removeIf(score -> !score.equals(BALL));
            return balls.size();
        }

        private Score toScore() {
            return new Score(countStrike(), countBall());
        }
    }
}
