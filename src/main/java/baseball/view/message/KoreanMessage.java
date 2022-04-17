package baseball.view.message;

import baseball.Hint;
import baseball.score.Score;

import java.util.Arrays;
import java.util.List;

import static baseball.Hint.*;

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

    // TODO: 이하 메세지가 아닌 view가 해야됨
    private final List<Hint> sortedOutputHints = Arrays.asList(BALL, STRIKE);

    public String toHint(Score score) {
        if (score.isNothing()) {
            return hintName(NOTHING);
        }
        String message = "";
        for (Hint hint : sortedOutputHints) {
            final int count = score.get(hint);
            final String name = hintName(hint);
            message += hint(count, name);
        }
        return message.trim();
    }

    private String hint(int count, String name) {
        return String.format("%d%s ", count, name);
    }
}
