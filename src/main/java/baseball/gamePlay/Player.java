package baseball.gamePlay;

import baseball.gameStrategy.Score;
import java.util.List;

public interface Player {

    List<Integer> guessBalls(); // TODO: List<Integer>

    boolean guessStartNewGame();

    void announceScore(Score score);
}
