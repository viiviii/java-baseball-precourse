package baseball;

import baseball.io.ComputerController;
import baseball.io.ConsoleController;
import baseball.io.Controller;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 값 만들기 (출제자 게임 숫자 뽑음) → Randoms
        // TODO: 테스트 추가
        // TODO: 실제로는 Host의 입력 값도 파싱하는 로직이 있어야한다
        Controller randomController = new ComputerController();
        Host host = new Host(randomController);
        String think = host.think();

        // 값 입력받기 (맞추는 사람이 값 입력) → Console
        Controller consoleController = new ConsoleController();
        Guessers guessers = new Guessers(consoleController);
        String guess = guessers.guess();

        //     - 입력 받은 값 파싱하기
        List<Integer> numbersOfGuessers = Parser.parseIntegerList(guess);
        GameNumbers gameNumbersOfGuessers = new GameNumbers(numbersOfGuessers);

        // 값 비교하기 (양측 게임 숫자 비교함)
        // 모두 맞췄으면 게임 종료
    }
}
