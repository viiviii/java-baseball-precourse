package baseball.view;

import baseball.domain.Scores;

public interface OutputView {

    void selectNumberRequest();

    void selectNumberResponse(Scores scores); // TODO: domain

    void perfectScore();

    void startNewGame();
}
