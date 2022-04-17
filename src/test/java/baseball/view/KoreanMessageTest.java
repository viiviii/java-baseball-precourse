package baseball.view;

import baseball.Hint;
import baseball.view.message.KoreanMessage;
import baseball.view.message.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static baseball.Hint.*;
import static org.assertj.core.api.Assertions.assertThat;

class KoreanMessageTest {

    private Message message = new KoreanMessage();

    @Test
    void 승리() {
        //when
        String msg = message.win();

        //then
        assertThat(msg).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); // TODO: 하드코딩 제거(3)
    }

    @Test
    void 게임_재시작_선택() {
        //when
        String msg = message.continueNewGame();

        //then
        assertThat(msg).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); // TODO: 하드코딩 제거(1, 2)
    }

    @Test
    void 게임_숫자_입력() {
        //when
        String msg = message.inputGameNumbers();

        //then
        assertThat(msg).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void 힌트_이름() {
        // when
        String strike = message.hintName(STRIKE);
        String ball = message.hintName(BALL);
        String nothing = message.hintName(NOTHING);

        //then
        assertThat(strike).isEqualTo("스트라이크");
        assertThat(ball).isEqualTo("볼");
        assertThat(nothing).isEqualTo("낫싱");
    }

    @ParameterizedTest
    @EnumSource(Hint.class)
    void 힌트는_모두_이름이_있다(Hint hint) {
        //when
        String msg = message.hintName(hint);

        //then
        assertThat(msg).isNotBlank();
    }
}