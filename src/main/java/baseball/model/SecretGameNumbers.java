package baseball.model;

import java.util.EnumMap;
import java.util.Map;

import static baseball.model.Hint.*;

public class SecretGameNumbers {
    private final GameNumbers gameNumbers;

    private SecretGameNumbers(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public static SecretGameNumbers from(GameNumbers gameNumbers) {
        return new SecretGameNumbers(gameNumbers);
    }

    public Score matchOf(GameNumbers otherNumbers) {
        final ScoreRecord score = new ScoreRecord();
        for (int i = 0; i < gameNumbers.size(); i++) {
            final Integer base = gameNumbers.get(i);
            final Integer other = otherNumbers.get(i);
            final Hint hint = match(base, other);
            score.recordOf(hint);
        }
        return score;
    }

    private Hint match(Integer gameNumber, Integer other) {
        if (gameNumber.equals(other)) {
            return STRIKE;
        }
        if (gameNumbers.contains(other)) {
            return BALL;
        }
        return NOTHING;
    }

    private static final class ScoreRecord implements Score {
        private final Map<Hint, Integer> score = new EnumMap<>(Hint.class);

        private void recordOf(Hint hint) {
            final int count = getCount(hint);
            score.put(hint, count + 1);
        }

        @Override
        public int getCount(Hint hint) {
            return score.getOrDefault(hint, 0);
        }

        @Override
        public boolean isAllStrike() {
            return isAll(STRIKE);
        }

        @Override
        public boolean isAllNothing() {
            return isAll(NOTHING);
        }

        private boolean isAll(Hint hint) {
            return score.size() == 1 && score.containsKey(hint);
        }
    }
}
