package baseball.view;

import baseball.score.Score;

public interface View {

    String input();

    void outputScoreMessage(Score score);

    void outputWinMessage();

    void outputContinueNewGameMessage();
}
