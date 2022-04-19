package baseball.model;

public interface Score {

    boolean isAllStrike();

    boolean isAllNothing();

    int getCount(Hint hint);
}
