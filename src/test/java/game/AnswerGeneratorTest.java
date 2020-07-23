package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnswerGeneratorTest {

    private GuessNumberGame guessNumberGame = new GuessNumberGame();
    @Test
    void should_return_true_when_is_valid_answer_numbers_given_random_answer_numbers() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int[] answerNumbers = answerGenerator.generate();

        //when
        boolean result = guessNumberGame.isValidNumbers(answerNumbers);

        //then
        assertTrue(result);
    }
}
