package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerGeneratorTest {

    private final GuessNumberGame guessNumberGame = new GuessNumberGame();

    @Test
    void should_random_answer_numbers_length_is_4_when_generate_numbers_given() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        int[] answerNumbers = answerGenerator.generate();

        //then
        Assertions.assertEquals(4, answerNumbers.length);
    }
}
