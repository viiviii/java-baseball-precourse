package baseball.model;

import java.util.Objects;

public final class SelectGameContinue {
    public static final SelectGameContinue NEW_GAME_START = new SelectGameContinue("1");
    public static final SelectGameContinue EXIT_GAME = new SelectGameContinue("2");

    private final String code;

    private SelectGameContinue(String code) {
        this.code = code;
    }

    public static SelectGameContinue fromString(String code) {
        validate(code);
        return new SelectGameContinue(code);
    }

    private static void validate(String code) {
        if (!(code.equals(NEW_GAME_START.code) || code.equals(EXIT_GAME.code))) {
            throw new IllegalArgumentException("유효하지 않은 게임 진행 코드입니다");
        }
    }

    public String code() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SelectGameContinue)) return false;
        SelectGameContinue that = (SelectGameContinue) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
