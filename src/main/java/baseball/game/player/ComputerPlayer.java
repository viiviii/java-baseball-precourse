package baseball.game.player;

import baseball.model.GameNumbers;
import baseball.model.Score;
import baseball.model.SecretGameNumbers;
import baseball.model.SelectGameContinue;
import baseball.util.MyRandoms;

import java.util.List;

public class ComputerPlayer implements Player {

    @Override
    public SecretGameNumbers think() {
        return SecretGameNumbers.from(randomGameNumbers());
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
        return GameNumbers.fromIntegers(randomNumbers);
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
    public SelectGameContinue wantContinueWithNewGame() {
        // computer doesn't want
        return SelectGameContinue.EXIT_GAME;
    }
}
