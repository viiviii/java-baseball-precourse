package baseball.game.player;

import baseball.game.Game;
import baseball.model.Balls;
import baseball.model.Score;
import baseball.model.SecretBalls;
import baseball.model.SelectGameContinue;
import baseball.util.MyRandoms;

import java.util.List;

public class ComputerPlayer implements Player {

    @Override
    public SecretBalls think() {
        return SecretBalls.from(randomBalls());
    }

    @Override
    public Balls guess() {
        return randomBalls();
    }

    private Balls randomBalls() {
        final List<Integer> randoms = MyRandoms
                .pickUniqueNumbersInRange(Game.START_NUMBER, Game.END_NUMBER, Game.DIGITS);
        return Balls.fromIntegers(randoms);
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
