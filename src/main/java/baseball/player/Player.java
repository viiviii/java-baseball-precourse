package baseball.player;

import baseball.GameNumbers;
import baseball.player.input.GameProgressStatus;
import baseball.score.Score;

public interface Player {

    GameNumbers think();

    GameNumbers guess();

    GameProgressStatus wantContinueNewGame();

    void announceContinueNewGame();

    void announceWin();

    void announceScore(Score score); // TODO: String으로 메세지 받나?
}
