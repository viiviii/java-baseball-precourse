package baseball.player;

import baseball.player.input.GameNumbers;
import baseball.player.input.GameProgressStatus;
import baseball.score.Score;

public interface Player {

    GameNumbers think();

    GameNumbers guess();

    GameProgressStatus wantContinueNewGame();

    void announceContinueNewGame();

    void announceWin();

    void announceScore(Score score);
}
