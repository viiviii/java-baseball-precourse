package baseball;

import baseball.player.ComputerPlayer;
import baseball.player.Player;
import baseball.player.PlayerImpl;
import baseball.view.ConsoleView;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // 값 만들기 (출제자 게임 숫자 뽑음) → Randoms
        // TODO: 테스트 추가
        // TODO: 실제로는 Host의 입력 값도 파싱하는 로직이 있어야한다
        Player host = new ComputerPlayer();
        GameNumbers gameNumbersOfHost = host.think();

        // 값 입력받기 (맞추는 사람이 값 입력) → Console
        View view = new ConsoleView();
        Player guessers = new PlayerImpl(view);
        GameNumbers gameNumbersOfGuessers = guessers.guess();

        // 값 비교하기 (양측 게임 숫자 비교함)
        // 모두 맞췄으면 게임 종료
    }
}
