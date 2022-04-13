package baseball;

public final class Guessers {

    private final SomeOther someOther;

    public Guessers(SomeOther someOther) {
        this.someOther = someOther;
    }

    public Object guess() {
        return someOther.input();
    }
}
