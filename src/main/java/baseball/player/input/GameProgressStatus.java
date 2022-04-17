package baseball.player.input;

import java.util.Objects;

public final class GameProgressStatus {

    public static final GameProgressStatus NEW_GAME_START = new GameProgressStatus("1");
    public static final GameProgressStatus EXIT_APPLICATION = new GameProgressStatus("2");

    private final String code;

    private GameProgressStatus(String code) {
        this.code = code;
    }

    public static GameProgressStatus fromString(String code) {
        validate(code);
        return new GameProgressStatus(code);
    }

    private static void validate(String code) {
        if (!(code.equals(NEW_GAME_START.code) || code.equals(EXIT_APPLICATION.code))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameProgressStatus)) return false;
        GameProgressStatus that = (GameProgressStatus) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
