package baseball.score;

import baseball.Hint;

import java.util.List;

public interface Score {

    boolean isAllStrike();

    boolean isAllNothing();

    int getCount(Hint hint);

    List<Match> matches();
}
