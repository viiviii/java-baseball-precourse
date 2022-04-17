package baseball.view;

public interface View {

    String input();

    void outputScoreMessage(String message);

    void outputWinMessage();

    void outputContinueNewGameMessage();
}
