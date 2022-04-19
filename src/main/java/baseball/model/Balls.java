package baseball.model;

import baseball.game.Game;
import baseball.util.Parser;

import java.util.*;

public final class Balls {
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        validateSize(balls);
        validateDuplicationBallNumber(balls);
        this.balls = balls;
    }

    public static Balls fromIntegers(List<Integer> numbers) {
        final List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            balls.add(new Ball(i, numbers.get(i)));
        }
        return new Balls(balls);
    }

    public static Balls fromString(String str) {
        try {
            final List<Integer> numbers = Parser.asIntegerList(str);
            return Balls.fromIntegers(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임숫자는 숫자만 가능합니다");
        }
    }

    private void validateSize(List<Ball> balls) {
        if (balls.size() != Game.DIGITS) {
            final String message = String.format("게임숫자는 %d 자리의 수여야 합니다", Game.DIGITS);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateDuplicationBallNumber(List<Ball> balls) {
        final Set<BallNumber> set = new HashSet<>();
        for (Ball ball : balls) {
            set.add(ball.getNumber());
        }
        if (balls.size() != set.size()) {
            throw new IllegalArgumentException("게임숫자는 서로 다른 수로 이루어져야 합니다");
        }
    }

    public Score scoreOf(Balls other) {
        final Score score = new Score();
        for (Ball ball : balls) {
            final Hint hint = other.matchOf(ball);
            score.recordOf(hint);
        }
        return score;
    }

    private Hint matchOf(Ball other) {
        if (isStrike(other)) {
            return Hint.STRIKE;
        }
        if (isBall(other)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    private boolean isStrike(Ball ball) {
        return balls.contains(ball);
    }

    private boolean isBall(Ball other) {
        final Set<Hint> hints = new HashSet<>();
        for (Ball ball : balls) {
            final Hint hint = ball.matchOf(other);
            hints.add(hint);
        }
        return hints.contains(Hint.BALL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balls)) return false;
        Balls that = (Balls) o;
        return balls.equals(that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    @Override
    public String toString() {
        return "Balls{" + "balls=" + balls + '}';
    }
}
