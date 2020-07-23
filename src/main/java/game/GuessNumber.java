package game;

import java.util.HashMap;
import java.util.Map;

public class GuessNumber {

    public String guess(int[] answer, int[] guessNumbers) {
//        boolean isAllRight = true;
        int countNumberInAnswerAndPositionRight = 0;
        int countNumberInAnswerButWrongPosition = 0;
        for (int i = 0; i < guessNumbers.length; i++) {
            for (int j=0; j < answer.length; j++){
                if (guessNumbers[i] == answer[j] && i==j){
                    countNumberInAnswerAndPositionRight ++;
                }
                if(guessNumbers[i] == answer[j] && i!=j){
                    countNumberInAnswerButWrongPosition++;
                }
            }
        }

        return countNumberInAnswerAndPositionRight +"A"+countNumberInAnswerButWrongPosition+"B";
    }
}
