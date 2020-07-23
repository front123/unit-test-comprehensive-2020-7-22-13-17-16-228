package game;

public class GuessNumber {

    public String guess(int[] answer, int[] guessNumbers) {
        boolean isAllRight = true;
        for (int i = 0; i < answer.length; i++) {
            if(answer[i]!=guessNumbers[i]) {
                isAllRight = false;
                break;
            }
        }
        if (isAllRight){
            return "4A0B";
        }
        return "0A0B";
    }
}
