package game;

public class TimesLimiter {
    private final int maxTimes;

    public TimesLimiter(int maxTimes) {
        this.maxTimes = maxTimes;
    }

    public int increase() {
        return 1;
    }
}
