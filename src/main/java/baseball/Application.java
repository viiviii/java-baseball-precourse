package baseball;

import baseball.player.ComputerPlayer;
import baseball.player.Player;
import baseball.player.PlayerImpl;
import baseball.score.Match;
import baseball.score.Score;
import baseball.view.ConsoleView;
import baseball.view.View;

public class Application {
    public static void main(String[] args) {
        // 값 만들기 (출제자 게임 숫자 뽑음) → Randoms
        // TODO: 테스트 추가
        // TODO: 메서드 위치 정리
        Player host = new ComputerPlayer();
        GameNumbers gameNumbersOfHost = host.think();

        // 값 입력받기 (맞추는 사람이 값 입력) → Console
        View view = new ConsoleView();
        Player guessers = new PlayerImpl(view);
        GameNumbers gameNumbersOfGuessers = guessers.guess();

        // 값 비교하기 (양측 게임 숫자 비교함)
        Match match = Match.baseOn(gameNumbersOfHost);
        Score score = match.scoreOf(gameNumbersOfGuessers);

        Message message = new Message();
        // 무조건 힌트 메세지 1회 출력
        String scoreMessage = message.toHint(score); // TODO: scoreMessage가 더 낫나?
        guessers.viewResult(scoreMessage);

        // 전부 맞췄는지 확인
        //  - true: 추가 메세지와 게임 재시작 메세지 출력
        //  - false: 다시 추측 받음
        // 모두 맞췄으면 게임 종료
    }
}
