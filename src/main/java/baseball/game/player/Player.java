package baseball.game.player;

import baseball.model.GameNumbers;
import baseball.model.GameProgressStatus;
import baseball.model.Score;

public interface Player {

    GameNumbers think();

    GameNumbers guess();

    GameProgressStatus wantContinueNewGame();

    void announceContinueNewGame();

    void announceWin();

    void announceScore(Score score);
}
