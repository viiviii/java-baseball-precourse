package baseball.view.message;

import baseball.game.Game;
import baseball.model.Hint;

import java.util.EnumMap;
import java.util.Map;

import static baseball.model.Hint.*;
import static baseball.model.SelectGameContinue.EXIT_GAME;
import static baseball.model.SelectGameContinue.NEW_GAME_START;

public class KoreanMessage implements Message {
    final Map<Hint, String> hintNames = new EnumMap<>(Hint.class);

    public KoreanMessage() {
        hintNames.put(STRIKE, "스트라이크");
        hintNames.put(BALL, "볼");
        hintNames.put(NOTHING, "낫싱");
    }

    @Override
    public String win() {
        return String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", Game.DIGITS);
    }

    @Override
    public String continueNewGame() {
        return String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", NEW_GAME_START.code(), EXIT_GAME.code());
    }

    @Override
    public String inputBalls() {
        return "숫자를 입력해주세요 : ";
    }

    @Override
    public String hintName(Hint hint) {
        return hintNames.get(hint);
    }
}
