package baseball;

import baseball.io.ComputerController;
import baseball.io.ConsoleController;
import baseball.io.Controller;
import baseball.player.Guessers;
import baseball.player.Host;

public class Application {
    public static void main(String[] args) {
        // 값 만들기 (출제자 게임 숫자 뽑음) → Randoms
        // TODO: 테스트 추가
        // TODO: 실제로는 Host의 입력 값도 파싱하는 로직이 있어야한다
        Controller randomController = new ComputerController();
        Host host = new Host(randomController);
        GameNumbers gameNumbersOfHost = host.think();

        // 값 입력받기 (맞추는 사람이 값 입력) → Console
        Controller consoleController = new ConsoleController();
        Guessers guessers = new Guessers(consoleController);
        GameNumbers gameNumbersOfGuessers = guessers.guess();

        // 값 비교하기 (양측 게임 숫자 비교함)
        // 모두 맞췄으면 게임 종료
    }
}
