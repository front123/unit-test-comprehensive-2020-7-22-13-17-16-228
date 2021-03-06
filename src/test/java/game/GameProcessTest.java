package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameProcessTest {
    private final INumberGenerator answerGenerator = mock(INumberGenerator.class);
    private final InputValidator inputValidator = mock(InputValidator.class);
    private final GuessNumberGame guessNumberGame = mock(GuessNumberGame.class);
    private final TimesLimiter timesLimiter = mock(TimesLimiter.class);
    @Test
    void should_output_wrong_message_when_play_given_guess_numbers_1232() throws TimesOutException {
        //given
        int[] answer = {1,2,3,4};
        int[] guessNumbers = {1, 2, 3, 2};
        when(guessNumberGame.getAnswer()).thenReturn(answer);
        when(inputValidator.isValidNumbers(guessNumbers)).thenReturn(false);
        GameProcess gameProcess = new GameProcess(guessNumberGame, inputValidator, timesLimiter);

        //when
        String result = gameProcess.play(guessNumbers);
        //then
        assertEquals("Wrong Input，Input again", result);
    }

    @Test
    void should_return_win_message_when_play_given_numbers_1234_and_answer_1234() throws TimesOutException {
        int[] answer = {1, 2, 3, 4};
        int[] guessNumbers = {1, 2, 3, 4};
        when(guessNumberGame.getAnswer()).thenReturn(answer);
        when(inputValidator.isValidNumbers(guessNumbers)).thenReturn(true);
        when(guessNumberGame.guess(guessNumbers)).thenReturn("4A0B");
        GameProcess gameProcess = new GameProcess(guessNumberGame, inputValidator, timesLimiter);

        //when
        String result = gameProcess.play(guessNumbers);
        //then
        assertEquals("4A0B", result);
    }

    @Test
    void should_throw_times_out_exception_when_play_given_times_limiter_times_use_more_than_6() throws TimesOutException {
        int[] answer = {1, 2, 3, 4};
        int[] guessNumbers = {1, 2, 3, 4};
        when(guessNumberGame.getAnswer()).thenReturn(answer);
        when(inputValidator.isValidNumbers(guessNumbers)).thenReturn(true);
        when(guessNumberGame.guess(guessNumbers)).thenReturn("4A0B");
        when(timesLimiter.increase()).thenThrow(TimesOutException.class);
        GameProcess gameProcess = new GameProcess(guessNumberGame, inputValidator, timesLimiter);

        //when
        Throwable throwable = Assertions.assertThrows(TimesOutException.class, ()->gameProcess.play(guessNumbers));
        //then
        Assertions.assertNotNull(throwable);
    }
}
