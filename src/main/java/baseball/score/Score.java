package baseball.score;

import baseball.Hint;

public interface Score {

    boolean isNothing();

    int get(Hint hint);
}
