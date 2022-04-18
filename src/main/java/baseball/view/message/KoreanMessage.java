package baseball.view.message;

import baseball.game.Game;
import baseball.model.Hint;

import static baseball.model.SelectGameContinue.EXIT_GAME;
import static baseball.model.SelectGameContinue.NEW_GAME_START;

public class KoreanMessage implements Message {

    @Override
    public String win() {
        return String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", Game.DIGITS);
    }

    @Override
    public String continueNewGame() {
        return String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", NEW_GAME_START.code(), EXIT_GAME.code());
    }

    @Override
    public String inputGameNumbers() {
        return "숫자를 입력해주세요 : ";
    }

    @Override
    public String hintName(Hint hint) {
        String name = "";
        switch (hint) {
            case STRIKE:
                name = "스트라이크";
                break;
            case BALL:
                name = "볼";
                break;
            case NOTHING:
                name = "낫싱";
                break;
        }
        return name;
    }
}
