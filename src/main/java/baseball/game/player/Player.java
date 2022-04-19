package baseball.game.player;

import baseball.model.Balls;
import baseball.model.Score;
import baseball.model.SecretBalls;
import baseball.model.SelectGameContinue;

public interface Player {

    SecretBalls think();

    Balls guess();

    SelectGameContinue wantContinueWithNewGame();

    void announceContinueNewGame();

    void announceWin();

    void announceScore(Score score);
}
