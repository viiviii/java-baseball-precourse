package baseball;

import baseball.score.Score;

import java.util.EnumMap;
import java.util.Map;

public class Marker {

    private final GameNumbers gameNumbers;

    private Marker(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    // TODO: 메서드명
    public static Marker origin(GameNumbers gameNumbers) {
        return new Marker(gameNumbers);
    }

    public Score compareWith(GameNumbers other) {
        final MarkerScore score = new MarkerScore();
        for (int i = 0; i < gameNumbers.size(); i++) {
            final HintStatus hintStatus = getHintStatus(other.get(i), i);
            score.count(hintStatus);
        }
        return score;
    }

    private HintStatus getHintStatus(Integer target, int index) {
        if (gameNumbers.get(index).equals(target)) {
            return HintStatus.STRIKE;
        }
        if (gameNumbers.contains(target)) {
            return HintStatus.BALL;
        }
        return HintStatus.NOTHING;
    }

    private static final class MarkerScore implements Score {
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
