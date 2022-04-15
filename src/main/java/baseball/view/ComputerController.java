package baseball.io;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerController implements Controller {

    @Override
    public String input() {
        return randomNumbers() + "";
    }

    private List<Integer> randomNumbers() {
        final int start = 1; // TODO
        final int end = 9;
        final int count = 3;
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
