package baseball.score;

import baseball.GameNumbers;
import baseball.HintStatus;

import java.util.EnumMap;
import java.util.Map;

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
            final HintStatus hintStatus = getHintStatus(other.get(i), i); // TODO
            score.count(hintStatus);
        }
        return score;
    }

    private HintStatus getHintStatus(Integer target, int index) {
        if (gameNumbers.get(index).equals(target)) { // TODO
            return HintStatus.STRIKE;
        }
        if (gameNumbers.contains(target)) {
            return HintStatus.BALL;
        }
        return HintStatus.NOTHING;
    }

    private static final class MatchScore implements Score {
        private final Map<HintStatus, Integer> score = new EnumMap<>(HintStatus.class);

        private void count(HintStatus hintStatus) {
            final int current = score.getOrDefault(hintStatus, 0);
            score.put(hintStatus, current + 1);
        }

        public int get(HintStatus hintStatus) {
            return score.get(hintStatus);
        }

        public boolean isNothing() {
            return score.get(HintStatus.NOTHING) == 3; // TODO: 하드코딩 제거(넘버 자릿수와 비교해야함)
        }
    }
}
