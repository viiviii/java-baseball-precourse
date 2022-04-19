package baseball.model;

import baseball.game.Game;

public final class Score {
    private int strike;
    private int ball;

    public void recordOf(Hint hint) {
        if (hint.isStrike()) {
            strike += 1;
        }
        if (hint.isBall()) {
            ball += 1;
        }
    }

    public boolean isPerfectStrike() {
        return getStrike() == Game.DIGITS;
    }

    public boolean isNothing() {
        return getStrike() == 0 && getBall() == 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
