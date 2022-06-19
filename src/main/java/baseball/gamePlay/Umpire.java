package baseball.gamePlay;

import baseball.gameStrategy.Balls;

public interface Umpire {

    Score call(Balls balls, Balls otherBalls);
}
