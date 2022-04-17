package baseball.score;

import baseball.Hint;

public interface Score {

    boolean isAllStrike();

    boolean isNothing();

    int get(Hint hint);

    Iterable<Match> matches();
}
