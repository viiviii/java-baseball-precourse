package baseball.view;

import baseball.domain.Score;

public interface OutputView {

    void ballNumbers();

    void score(Score score); // TODO: domain

    void startNewGame();
}
