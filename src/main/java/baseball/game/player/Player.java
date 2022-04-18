package baseball.game.player;

import baseball.model.GameNumbers;
import baseball.model.GameProgressStatus;
import baseball.model.Score;
import baseball.model.SecretGameNumbers;

public interface Player {

    SecretGameNumbers think();

    GameNumbers guess();

    GameProgressStatus wantContinueNewGame();

    void announceContinueNewGame();

    void announceWin();

    void announceScore(Score score);
}
