package baseball.score;

import baseball.GameNumbers;
import baseball.Hint;

import java.util.EnumMap;
import java.util.Map;

import static baseball.Hint.*;

public class Match {

    private final GameNumbers gameNumbers;

    private Match(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public static Match baseOn(GameNumbers gameNumbers) {
        return new Match(gameNumbers);
    }

    public Score scoreOf(GameNumbers other) {
        final MatchScore score = new MatchScore();
        for (int i = 0; i < gameNumbers.size(); i++) {
            final Hint hint = getHint(other.get(i), i); // TODO
            score.count(hint);
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

    private static final class MatchScore implements Score {
        private final Map<Hint, Integer> score = new EnumMap<>(Hint.class);

        private void count(Hint hint) {
            final int current = score.getOrDefault(hint, 0);
            score.put(hint, current + 1);
        }

        public int get(Hint hint) {
            return score.get(hint);
        }

        public boolean isNothing() {
            return score.get(NOTHING) == 3; // TODO: 하드코딩 제거(넘버 자릿수와 비교해야함)
        }
    }
}
