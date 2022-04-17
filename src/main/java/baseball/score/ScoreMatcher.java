package baseball.score;

import baseball.GameNumbers;
import baseball.Hint;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
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
            final int count = getCount(hint);
            score.put(hint, count + 1);
        }

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

        @Override
        public List<Match> matches() {
            final List<Match> matches = new ArrayList<>();
            for (Map.Entry<Hint, Integer> map : score.entrySet()) {
                final Match match = new Match(map.getKey(), map.getValue());
                matches.add(match);
            }
            return matches;
        }
    }
}
