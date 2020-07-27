package game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final INumberGenerator answerGenerator = mock(INumberGenerator.class);
    @Test
    void should_return_4A0B_when_guess_given_answer_1234_and_guess_numbers_1234() {
        //given
        when(answerGenerator.generate()).thenReturn(new int[]{1,2,3,4});
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        int[] guessNumbers = {1,2,3,4};

        //when
        String result = guessNumberGame.guess(guessNumberGame.getAnswer(), guessNumbers);

        //then
        assertEquals("4A0B", result);
    }

    @Test
    void should_return_0A0B_when_guess_given_answer_1234_and_guess_numbers_5678() {
        //given
        int[] answer = {1,2,3,4};
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        int[] guessNumbers = {5,6,7,8};

        //when
        String result = guessNumberGame.guess(answer, guessNumbers);

        //then
        assertEquals("0A0B", result);
    }

    @Test
    void should_return_2A0B_when_guess_given_answer_1234_and_guess_numbers_1256() {
        //given
        int[] answer = {1,2,3,4};
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        int[] guessNumbers = {1,2,5,6};

        //when
        String result = guessNumberGame.guess(answer, guessNumbers);

        //then
        assertEquals("2A0B", result);
    }

    @Test
    void should_return_2A2B_when_guess_given_answer_1234_and_guess_numbers_1243() {
        //given
        int[] answer = {1,2,3,4};
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        int[] guessNumbers = {1,2,4,3};

        //when
        String result = guessNumberGame.guess(answer, guessNumbers);

        //then
        assertEquals("2A2B", result);
    }

    @Test
    void should_return_1A1B_when_guess_given_answer_1234_and_guess_numbers_1562() {
        //given
        int[] answer = {1,2,3,4};
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        int[] guessNumbers = {1,5,6,2};

        //when
        String result = guessNumberGame.guess(answer, guessNumbers);

        //then
        assertEquals("1A1B", result);
    }

    @Test
    void should_output_wrong_message_when_guess_given_1232() {
        //given
        int[] answer = {1,2,3,4};
        when(answerGenerator.generate()).thenReturn(answer);
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGenerator);
        int[] guessNumbers = {1,2,3,2};
        //when
        String result = guessNumberGame.play(answer,guessNumbers);
        //then
        assertEquals("Wrong Input，Input again", result);
    }
}
