package game;

import java.util.Arrays;

public class InputValidator {

    public boolean isValidNumbers(int[] guessNumbers) {
        return guessNumbers != null
                && isLengthEqual4(guessNumbers)
                && isInRange0To9(guessNumbers)
                && !hasDuplicateNumber(guessNumbers);
    }

    private boolean hasDuplicateNumber(int[] guessNumbers){
        return Arrays.stream(guessNumbers).distinct().count() < guessNumbers.length;
    }

    private boolean isLengthEqual4(int[] guessNumbers){
        return guessNumbers.length == 4;
    }
    private boolean isInRange0To9(int[] guessNumbers){
        return Arrays.stream(guessNumbers)
                .filter(number -> number>=0 && number<=9)
                .count() == guessNumbers.length;
    }
}
