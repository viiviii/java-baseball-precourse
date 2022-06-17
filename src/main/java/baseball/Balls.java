package baseball;

import java.util.ArrayList;
import java.util.List;

public final class Balls {
    private final List<Ball> values;

    private Balls(List<Ball> values) {
        this.values = values;
    }

    public static Balls of(int... numbers) {
        final List<Ball> balls = new ArrayList<>();
        for (int position = 0; position < numbers.length; position++) {
            final Ball ball = new Ball(position, numbers[position]);
            balls.add(ball);
        }
        return new Balls(balls);
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
