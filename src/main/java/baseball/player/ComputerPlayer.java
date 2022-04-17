package baseball.player;

import baseball.GameNumbers;
import baseball.MyRandoms;

import java.util.List;

public class ComputerPlayer implements Player {

    @Override
    public void viewResult(String message) {
        // computer does nothing
    }

    @Override
    public boolean wantContinueNewGame() {
        // computer doesn't want
        return false;
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
        final int start = 1; // TODO
        final int end = 9;
        final int count = 3;
        final List<Integer> randomNumbers = MyRandoms.pickUniqueNumbersInRange(start, end, count);
        return new GameNumbers(randomNumbers);
    }
}
