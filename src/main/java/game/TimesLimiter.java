package game;

public class TimesLimiter {
    private final int maxTimes;
    private int timesUsed;

    public TimesLimiter(int maxTimes) {
        this.maxTimes = maxTimes;
        this.timesUsed = 0;
    }

    public int increase() throws TimesOutException {
        this.timesUsed ++;
        if (this.timesUsed >= maxTimes){
            throw new TimesOutException();
        }
        return timesUsed;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }
}
