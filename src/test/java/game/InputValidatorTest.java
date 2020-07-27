package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();
    @Test
    void should_return_true_when_check_is_valid_guess_numbers_given_1234() {
        //given
        int[] guessNumbers = {1,2,3,4};
        //when
        boolean result = inputValidator.isValidNumbers(guessNumbers);
        //then
        assertTrue(result);
    }

    @Test
    void should_return_false_when_check_is_valid_guess_numbers_given_12341() {
        //given
        int[] guessNumbers = {1,2,3,4,1};
        //when
        boolean result = inputValidator.isValidNumbers(guessNumbers);
        //then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_check_is_valid_guess_numbers_given_123_10() {
        //given
        int[] guessNumbers = {1,2,3,10};
        //when
        boolean result = inputValidator.isValidNumbers(guessNumbers);
        //then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_check_is_valid_guess_numbers_given_123_with_a_negative_1() {
        //given
        int[] guessNumbers = {1,2,3,-1};
        //when
        boolean result = inputValidator.isValidNumbers(guessNumbers);
        //then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_check_is_valid_guess_numbers_given_1232() {
        //given
        int[] guessNumbers = {1,2,3,2};
        //when
        boolean result = inputValidator.isValidNumbers(guessNumbers);
        //then
        assertFalse(result);
    }

}
