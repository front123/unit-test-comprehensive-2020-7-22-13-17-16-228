package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    @Test
    void should_distinct_numbers_amount_equal_answerNumbers_size_when_generate_numbers_given() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();

        //when
        int[] answerNumbers = answerGenerator.generate();
        long distinctAmount = Arrays.stream(answerNumbers).boxed()
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .count();

        //then
        Assertions.assertEquals(answerNumbers.length, distinctAmount);
    }
}
