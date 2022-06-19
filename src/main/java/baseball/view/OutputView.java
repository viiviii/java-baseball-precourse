package baseball.view;

import baseball.domain.Score;

public interface OutputView {

    void selectNumberRequest();

    void selectNumberResponse(Score score); // TODO: domain

    void startNewGame();
}
