package baseball;

public enum Hint {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String name;

    Hint(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
