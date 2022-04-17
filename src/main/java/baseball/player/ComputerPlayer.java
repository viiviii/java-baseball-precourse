package baseball.player;

import baseball.MyRandoms;
import baseball.player.input.GameNumbers;
import baseball.player.input.GameProgressStatus;
import baseball.score.Score;

import java.util.List;

public class ComputerPlayer implements Player {

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

    @Override
    public void announceScore(Score score) {
        // computer does nothing
    }

    @Override
    public void announceWin() {
        // computer does nothing
    }

    @Override
    public void announceContinueNewGame() {
        // computer does nothing
    }

    @Override
    public GameProgressStatus wantContinueNewGame() {
        // computer doesn't want
        return GameProgressStatus.EXIT_APPLICATION;
    }
}
