package baseball.player;

import baseball.GameNumbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerPlayer implements Player {

    @Override
    public void viewResult(String message) {
        // computer does nothing
    }

    @Override
    public GameNumbers think() {
        return randomGameNumbers();
    }

    @Override
    public GameNumbers guess() {
        return randomGameNumbers();
    }

    private GameNumbers randomGameNumbers() {
        final List<Integer> randomNumbers = randomNumbers();
        return new GameNumbers(randomNumbers);
    }

    private List<Integer> randomNumbers() {
        final int start = 1; // TODO
        final int end = 9;
        final int count = 3;
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
