package game;

public class GuessNumber {

    public String guess(int[] answer, int[] guessNumbers) {
//        boolean isAllRight = true;
        int countNumberInAnswerAndPositionRight = 0;
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == guessNumbers[i]){
                countNumberInAnswerAndPositionRight++;
            }
        }
        return countNumberInAnswerAndPositionRight +"A0B";
    }
}
