package game;

public class GuessNumber {

    public String guess(int[] answer, int[] guessNumbers) {

        return createFeedback(answer, guessNumbers);
    }

    public String createFeedback(int[] answer, int[] guessNumbers){
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

    public boolean isValidGuessNumbers(int[] guessNumbers) {
        return true;
    }
}
