package baseball.view.message;

import baseball.Hint;

public class KoreanMessage implements Message {

    @Override
    public String win() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    @Override
    public String continueNewGame() {
        return "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
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
