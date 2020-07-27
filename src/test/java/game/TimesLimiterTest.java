package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimesLimiterTest {

    @Test
    void should_times_used_equal_to_1_when_increase_given_a_times_limiter() {
        //given
        TimesLimiter timesLimiter = new TimesLimiter(6);

        //when
        int timesUsed = timesLimiter.increase();

        //then
        Assertions.assertEquals(1, timesUsed);
    }
}
