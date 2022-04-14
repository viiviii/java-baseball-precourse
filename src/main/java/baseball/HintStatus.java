package baseball;

public enum HintStatus {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String name;

    HintStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
