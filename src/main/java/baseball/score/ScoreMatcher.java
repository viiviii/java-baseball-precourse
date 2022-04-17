package baseball.score;

import baseball.GameNumbers;
import baseball.Hint;

import java.util.EnumMap;
import java.util.Map;

import static baseball.Hint.*;

public class ScoreMatcher {

    private final GameNumbers gameNumbers;

    private ScoreMatcher(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public static ScoreMatcher baseOn(GameNumbers gameNumbers) {
        return new ScoreMatcher(gameNumbers);
    }

    public Score scoreOf(GameNumbers other) {
        final RememberScore score = new RememberScore();
        for (int i = 0; i < gameNumbers.size(); i++) {
            final Hint hint = getHint(other.get(i), i); // TODO
            score.addCount(hint);
        }
        return score;
    }

    private Hint getHint(Integer target, int index) {
        if (gameNumbers.get(index).equals(target)) { // TODO
            return STRIKE;
        }
        if (gameNumbers.contains(target)) {
            return BALL;
        }
        return NOTHING;
    }

    private static final class RememberScore implements Score {
        private final Map<Hint, Integer> score = new EnumMap<>(Hint.class);

        private void addCount(Hint hint) {
            final int current = get(hint);
            score.put(hint, current + 1);
        }

        @Override
        public int get(Hint hint) {
            return score.getOrDefault(hint, 0);
        }

        @Override
        public boolean isAllStrike() {
            return get(STRIKE) == 3; // TODO: 하드코딩 제거(넘버 자릿수와 비교해야함)
        }

        @Override
        public boolean isNothing() {
            return get(NOTHING) == 3; // TODO: 하드코딩 제거(넘버 자릿수와 비교해야함)
        }
    }
}
