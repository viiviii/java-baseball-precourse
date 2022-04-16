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

        View view = new ConsoleView();
        Player guessers = new PlayerImpl(view);

        Match match = Match.baseOn(gameNumbersOfHost);
        Message message = new Message();

        // 값 확인 후 모두 맞출 때 까지 반복
        boolean isAllStrike = false;
        while (!isAllStrike) {
            // 값 입력받기 (맞추는 사람이 값 입력) → Console
            GameNumbers gameNumbersOfGuessers = guessers.guess();
            // 값 비교하기 (양측 게임 숫자 비교함)
            Score score = match.scoreOf(gameNumbersOfGuessers);
            // 무조건 점수 메세지 1회 출력
            guessers.viewResult(message.toHint(score)); // // TODO: scoreMessage가 더 낫나?
            // 모두 맞췄나?
            isAllStrike = score.isAllStrike();
        }
        guessers.viewResult(message.allStrike());

        // 플레이어 선택에 따라 게임 재시작 or 완전히 종료
        guessers.viewResult(message.continueNewGame());
        int wantContinueNewGame = guessers.wantContinueNewGame();
    }
}
