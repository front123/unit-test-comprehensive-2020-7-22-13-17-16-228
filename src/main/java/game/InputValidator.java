package game;

public class InputValidator {

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

}
