package baseball.view;

import baseball.model.Hint;
import baseball.view.message.KoreanMessage;
import baseball.view.message.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static baseball.model.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;

class KoreanMessageTest {
    private Message message = new KoreanMessage();

    @DisplayName("승리 메세지")
    @Test
    void messageWin() {
        //when
        String msg = message.win();

        //then
        assertThat(msg).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @DisplayName("게임 재시작 선택 메세지")
    @Test
    void messageContinueNewGame() {
        //when
        String msg = message.continueNewGame();

        //then
        assertThat(msg).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @DisplayName("게임 숫자 입력 메세지")
    @Test
    void messageInputBalls() {
        //when
        String msg = message.inputBalls();

        //then
        assertThat(msg).isEqualTo("숫자를 입력해주세요 : ");
    }

    @DisplayName("힌트 이름")
    @Test
    void hintName() {
        // when
        String strike = message.hintName(STRIKE);
        String ball = message.hintName(BALL);
        String nothing = message.hintName(NOTHING);

        //then
        assertThat(strike).isEqualTo("스트라이크");
        assertThat(ball).isEqualTo("볼");
        assertThat(nothing).isEqualTo("낫싱");
    }

    @DisplayName("힌트는 모두 이름이 있다")
    @ParameterizedTest
    @EnumSource(Hint.class)
    void allHintsHaveNames(Hint hint) {
        //when
        String msg = message.hintName(hint);

        //then
        assertThat(msg).isNotBlank();
    }
}