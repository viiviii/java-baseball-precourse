package baseball;

import java.util.EnumMap;
import java.util.Map;

// TODO: 채점자랑 힌트랑 두개가 섞여있는건가?
public class Marker {

    private final GameNumbers gameNumbers;

    private Marker(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    // TODO: 메서드명
    public static Marker origin(GameNumbers gameNumbers) {
        return new Marker(gameNumbers);
    }

    public String compareWith(GameNumbers other) {
        Map<HintStatus, Integer> map = new EnumMap<>(HintStatus.class);
        for (int i = 0; i < gameNumbers.size(); i++) {
            HintStatus hints = getHintStatus(other.get(i), i);
            map.put(hints, map.getOrDefault(hints, 0) + 1);
        }
        return toHint(map);
    }

    private String toHint(Map<HintStatus, Integer> map) {
        Integer nothingCount = map.getOrDefault(HintStatus.NOTHING, 0);
        if (nothingCount == 3) {
            return "낫싱";
        }
        String ball = "";
        String strike = "";

        boolean containsBall = map.containsKey(HintStatus.BALL);
        if (containsBall) {
            ball = map.get(HintStatus.BALL) + HintStatus.BALL.getName();
        }

        boolean containsStrike = map.containsKey(HintStatus.STRIKE);
        if (containsStrike) {
            strike = map.get(HintStatus.STRIKE) + HintStatus.STRIKE.getName();
        }

        //TODO: 공백 최선인가?
        return (ball + " " + strike).trim();

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
}
