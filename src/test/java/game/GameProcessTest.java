package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameProcessTest {
    private final INumberGenerator answerGenerator = mock(INumberGenerator.class);
    private final InputValidator inputValidator = mock(InputValidator.class);
    private final GuessNumberGame guessNumberGame = mock(GuessNumberGame.class);
    @Test
    void should_output_wrong_message_when_guess_given_1232() {
        //given
        int[] answer = {1, 2, 3, 4};
        int[] guessNumbers = {1, 2, 3, 2};
        when(answerGenerator.generate()).thenReturn(answer);
        when(inputValidator.isValidNumbers(guessNumbers)).thenReturn(false);
        GameProcess gameProcess = new GameProcess();

        //when
        String result = gameProcess.play(guessNumbers);
        //then
        assertEquals("Wrong Input，Input again", result);
    }
}
