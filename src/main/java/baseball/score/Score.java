package baseball.score;

import baseball.Hint;

public interface Score {

    boolean isAllStrike();

    boolean isAllNothing();

    int getCount(Hint hint);
}
