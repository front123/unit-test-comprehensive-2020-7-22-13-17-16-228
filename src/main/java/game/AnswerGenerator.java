package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnswerGenerator implements INumberGenerator {
    private final Integer[] numbers = {0,1,2,3,4,5,6,7,8,9};
    private final List<Integer> randomNumbersList = Arrays.asList(numbers);
    public int[] generate() {
        int[] answerNumbers = new int[4];
        Collections.shuffle(randomNumbersList);
        for (int i=0; i<4; i++){
            answerNumbers[i] = randomNumbersList.get(i);
        }
        return answerNumbers;
    }
}
