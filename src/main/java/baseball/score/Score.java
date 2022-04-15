package baseball.score;

import baseball.HintStatus;

public interface Score {

    boolean isNothing();

    int get(HintStatus hintStatus);
}
