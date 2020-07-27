package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimesLimiterTest {

    @Test
    void should_times_used_equal_to_1_when_increase_given_a_times_limiter() throws TimesOutException {
        //given
        TimesLimiter timesLimiter = new TimesLimiter(6);

        //when
        int timesUsed = timesLimiter.increase();

        //then
        Assertions.assertEquals(1, timesUsed);
    }

    @Test
    void should_throw_times_out_exception_when_increase_given_a_times_limiter_with_5_times_used(){
        //given
        TimesLimiter timesLimiter = new TimesLimiter(6);
        timesLimiter.setTimesUsed(5);
        //when
        Throwable throwable = Assertions.assertThrows(TimesOutException.class, timesLimiter::increase);
        //then
        Assertions.assertNotNull(throwable);
    }
}
