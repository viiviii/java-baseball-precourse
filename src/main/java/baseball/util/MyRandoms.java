package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MyRandoms {

    public static List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        validateCount(startInclusive, endInclusive, count);
        final Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < count) {
            final int random = Randoms.pickNumberInRange(startInclusive, endInclusive);
            randomNumbers.add(random);
        }
        return new ArrayList<>(randomNumbers);
    }

    private static void validateCount(int startInclusive, int endInclusive, int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
        if (endInclusive - startInclusive + 1 < count) {
            throw new IllegalArgumentException();
        }
    }
}
