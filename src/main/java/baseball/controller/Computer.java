package baseball.controller;

import baseball.util.MyRandoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Computer {
    private final MyRandoms randoms;

    public Computer(MyRandoms randoms) {
        this.randoms = randoms;
    }

    // TODO: 상수
    public List<Integer> ballNumbers() {
        final Set<Integer> uniqueBallNumbers = new HashSet<>();
        while (uniqueBallNumbers.size() < 3) {
            final int numbers = randoms.pickNumberInRange(1, 9);
            uniqueBallNumbers.add(numbers);
        }
        return new ArrayList<>(uniqueBallNumbers);
    }
}
