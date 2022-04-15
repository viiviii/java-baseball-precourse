package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Message {

    private final Map<HintStatus, Integer> hintCountMap;

    public Message(Map<HintStatus, Integer> hintCountMap) {
        this.hintCountMap = hintCountMap;
    }

    public String toHint() {
        if (containsAllNothing()) {
            return HintStatus.NOTHING.getName();
        }
        final List<HintStatus> hints = hintMessageOrder();
        String hintMessage = "";
        for (HintStatus hint : hints) {
            hintMessage += hintCountMap.get(hint) + hint.getName() + " ";
        }
        return hintMessage.trim();
    }

    private boolean containsAllNothing() {
        final Integer nothingCount = hintCountMap.getOrDefault(HintStatus.NOTHING, 0);
        return nothingCount == 3; // TODO: 하드코딩 제거
    }

    private List<HintStatus> hintMessageOrder() {
        final List<HintStatus> printableHintOrder = Arrays.asList(HintStatus.BALL, HintStatus.STRIKE);
        final List<HintStatus> hints = new ArrayList<>(printableHintOrder);
        hints.retainAll(hintCountMap.keySet());
        return hints;
    }
}
