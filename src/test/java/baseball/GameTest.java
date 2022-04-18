package baseball;

import baseball.parser.Parser;
import baseball.player.Player;
import baseball.player.input.GameNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class GameTest {

    private Player host = mock(Player.class);
    private Player guesser = mock(Player.class);
    private Game game;

    // - 설정 논리는 일반 실행 논리와 분리해야 모듈성이 높아진다
    //
    // - 주요 의존성을 해소하기 위한 방식은 일관적이어야 한다
    // - 시스템 생성과 시스템 사용을 분리하는 방법
    //      - 생성과 관련한 코드는 모두 main이나 main이 호출하는 모듈로 옮기고
    //      - 나머지 시스템은 모든 객체가 생성되었고 모든 의존성이 연결되었다고 가정한다
    //          - main 함수에서 시스템에 필요한 객체를 생성 후 애플리케이션을 넘기고, 애플리케이션은 그저 객체를 사용한다
    //          - 애플리케이션은 main이나 객체가 생성되는 과정을 전혀 모른다
    // - 객체가 생성되는 시점을 애플리케이션이 결정할 필요도 생긴다. -> 팩토리 부분
    //      - 애플리케이션은 LineItem 시점은 결정하지만 생성 코드는 모른다 -> 인터페이스 사용하고 있으니까


    @BeforeEach
    void setUp() {
        Game game = Game.Builder()
                .host(host)
                .guesser(guesser)
                .build();
    }

    @Test
    void 출제자가_게임숫자를_생각한다() {
        //given
        GameNumbers hostThink = parseAsGameNumbers("123");
        GameNumbers guess1 = parseAsGameNumbers("456");
        GameNumbers guess2 = parseAsGameNumbers("129");

        given(host.think()).willReturn(hostThink);
        given(guesser.guess()).willReturn(guess1, guess2, hostThink);

        //when
        game.start();

        //then
        verify(host, only()).think();
    }

    @Test
    void 질문자는_게임숫자를_맞출때까지_추측한다() {
        //given
        GameNumbers hostThink = parseAsGameNumbers("123");
        GameNumbers guess1 = parseAsGameNumbers("456");
        GameNumbers guess2 = parseAsGameNumbers("129");

        given(host.think()).willReturn(hostThink);
        given(guesser.guess()).willReturn(guess1, guess2, hostThink);

        //when
        game.start();

        //then
        verify(guesser, times(3)).guess();
    }

    // TODO: 테스트 뭔가 이상함
    @Test
    void 게임을_다시_시작하거나_완전히_종료할_수_있다() {
        //given
        GameNumbers hostThinks = parseAsGameNumbers("123");

        given(host.think()).willReturn(hostThinks);
        given(guesser.guess()).willReturn(hostThinks);

        //when
        game.start();

        //then
        verify(guesser).wantContinueNewGame(); // TODO: wantContinueNewGame 메서드명 이상함 select?
    }

    private GameNumbers parseAsGameNumbers(String number) {
        return Parser.asGameNumbers(number);
    }
}