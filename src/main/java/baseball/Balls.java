package baseball;

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
        validateDuplicate(numbers); // TODO
        validateLength(numbers); // TODO
        final List<Ball> balls = new ArrayList<>();
        for (int position = 0; position < numbers.length; position++) {
            final Ball ball = new Ball(position, numbers[position]);
            balls.add(ball);
        }
        return new Balls(balls);
    }

    private static void validateDuplicate(Integer... numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        if (uniqueNumbers.size() != BALL_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLength(Integer... inputNumbers) {
        if (inputNumbers.length != BALL_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasSameBall(Ball ball) {
        return values.contains(ball);
    }

    public boolean hasSameNumber(Ball other) {
        for (Ball ball : values) {
            if (ball.isSameNumber(other)) { // TODO
                return true;
            }
        }
        return false;
    }

    public List<Ball> toList() {
        return new ArrayList<>(values);
    }
}
