package baseball.gameStrategy;

import static baseball.gameStrategy.Match.BALL;
import static baseball.gameStrategy.Match.NOTHING;
import static baseball.gameStrategy.Match.STRIKE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Balls {
    private static final int BALL_NUMBER_COUNT = 3;
    private final List<Ball> values;

    private Balls(List<Ball> values) {
        this.values = values;
    }

    public static Balls of(Integer... numbers) {
        return Balls.of(Arrays.asList(numbers));
    }

    public static Balls of(List<Integer> numbers) {
        validateDuplicate(numbers); // TODO
        validateLength(numbers); // TODO
        final List<Ball> balls = new ArrayList<>();
        for (int position = 0; position < numbers.size(); position++) {
            final Ball ball = new Ball(position, numbers.get(position));
            balls.add(ball);
        }
        return new Balls(balls);
    }

    private static void validateDuplicate(List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != BALL_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(List<Integer> inputNumbers) {
        if (inputNumbers.size() != BALL_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public Score scoreOf(Balls other) {
        final Score score = Score.init();
        for (Ball ball : values) {
            final Match match = other.matchOf(ball);
            score.increase(match);
        }
        return score;
    }

    private Match matchOf(Ball other) {
        if (hasStrike(other)) {
            return STRIKE;
        }
        if (hasBall(other)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean hasStrike(Ball ball) {
        return values.contains(ball);
    }

    // TODO
    private boolean hasBall(Ball otherBall) {
        final Set<Match> matches = new HashSet<>();
        for (Ball ball : values) {
            final Match match = ball.matchOf(otherBall);
            matches.add(match);
        }
        return matches.contains(BALL);
    }
}
