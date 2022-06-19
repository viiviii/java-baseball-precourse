package baseball.gamePlay;

import java.util.List;

public interface Player {

    List<Integer> guessBalls(); // TODO: List<Integer>

    boolean guessStartNewGame();

    void announceScore(Score score);
}