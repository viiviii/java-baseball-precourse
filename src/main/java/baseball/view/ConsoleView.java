package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements View {


    @Override
    public String input() {
        return Console.readLine();
    }

    @Override
    public void outputScoreMessage(String score) {
        output(score);
    }

    @Override
    public void outputWinMessage() {
        output("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void outputContinueNewGameMessage() {
        output("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void output(String message) {
        System.out.println(message);
    }
}
