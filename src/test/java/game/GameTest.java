package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    /*
    输入：
    answer:[int]
    guessNumbers:[int]
    输出:
    4A0B
     */
    @Test
    void should_return_4A0B_when_guess_given_answer_1234_and_guess_numbers_1234() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1,2,3,4};
        int[] guessNumbers = {1,2,3,4};

        //when
        String result = guessNumber.guess(answer, guessNumbers);

        //then
        assertEquals("4A0B", result);
    }

    /*
    输入：
    answer:[int]
    guessNumbers:[int]
    输出:
    0A0B
     */
    @Test
    void should_return_0A0B_when_guess_given_answer_1234_and_guess_numbers_5678() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1,2,3,4};
        int[] guessNumbers = {5,6,7,8};

        //when
        String result = guessNumber.guess(answer, guessNumbers);

        //then
        assertEquals("0A0B", result);
    }

    /*
    输入：
    answer:[int]
    guessNumbers:[int]
    输出:
    2A0B
     */
    @Test
    void should_return_2A0B_when_guess_given_answer_1234_and_guess_numbers_1256() {
        //given
        GuessNumber guessNumber = new GuessNumber();
        int[] answer = {1,2,3,4};
        int[] guessNumbers = {1,2,5,6};

        //when
        String result = guessNumber.guess(answer, guessNumbers);

        //then
        assertEquals("2A0B", result);
    }
}
