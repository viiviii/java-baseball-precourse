package baseball;

// TODO: ....상속?...
public abstract class Host {

    private GameNumbers gameNumbers;

    public void think() {
        gameNumbers = setGameNumbers();
    }

    protected abstract GameNumbers setGameNumbers();
}
