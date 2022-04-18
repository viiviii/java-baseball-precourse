package baseball.game.player;

import baseball.model.GameNumbers;
import baseball.model.Score;
import baseball.model.SecretGameNumbers;
import baseball.model.SelectGameContinue;

public interface Player {

    SecretGameNumbers think();

    GameNumbers guess();

    SelectGameContinue wantContinueWithNewGame();

    void announceContinueNewGame();

    void announceWin();

    void announceScore(Score score);
}
