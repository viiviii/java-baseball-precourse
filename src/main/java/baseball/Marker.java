package baseball;

import java.util.*;

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

    private String toHint(Map<HintStatus, Integer> hintCountMap) {
        if (containsAllNothing(hintCountMap)) {
            return HintStatus.NOTHING.getName();
        }
        final List<HintStatus> hints = hintMessageOrder(hintCountMap);
        String hintMessage = "";
        for (HintStatus hint : hints) {
            hintMessage += hintCountMap.get(hint) + hint.getName() + " ";
        }
        return hintMessage.trim();
    }

    private boolean containsAllNothing(Map<HintStatus, Integer> hintCountMap) {
        final Integer nothingCount = hintCountMap.getOrDefault(HintStatus.NOTHING, 0);
        return nothingCount == gameNumbers.size();
    }

    private List<HintStatus> hintMessageOrder(Map<HintStatus, Integer> hintCountMap) {
        final List<HintStatus> printableHintOrder = Arrays.asList(HintStatus.BALL, HintStatus.STRIKE);
        final List<HintStatus> hints = new ArrayList<>(printableHintOrder);
        hints.retainAll(hintCountMap.keySet());
        return hints;
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
