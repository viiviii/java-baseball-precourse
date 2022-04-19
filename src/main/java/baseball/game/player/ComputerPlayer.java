package baseball.game.player;

import baseball.game.Game;
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
        final List<Integer> randomNumbers = MyRandoms
                .pickUniqueNumbersInRange(Game.START_NUMBER, Game.END_NUMBER, Game.DIGITS);
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
