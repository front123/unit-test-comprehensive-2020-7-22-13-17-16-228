package game;

public class GuessNumberGame {

    private int[] answer;
    public GuessNumberGame() {
    }
    public GuessNumberGame(INumberGenerator numberGenerator){
        this.answer = numberGenerator.generate();
    }

    public String guess(int[] answer, int[] guessNumbers) {
        if (!isValidNumbers(guessNumbers)){
            return "Wrong Input，Input again";
        }
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

    public boolean isValidNumbers(int[] guessNumbers) {
        if (guessNumbers==null || guessNumbers.length != 4) {
            return false;
        }
        for (int number: guessNumbers) {
            if(number>9 || number<0) {
                return false;
            }
        }
        for (int i=0; i<guessNumbers.length; i++){
            for(int j=0; j<guessNumbers.length; j++){
                if(guessNumbers[i] == guessNumbers[j] && i!=j){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getAnswer() {
        return answer;
    }
}
