package game;

public class GameProcess {
    private final InputValidator inputValidator = new InputValidator();
    private GuessNumberGame guessNumberGame;
    public String play(int[] guessNumbers) {
        if (!inputValidator.isValidNumbers(guessNumbers)) {
            return "Wrong Input，Input again";
        }
        return guessNumberGame.guess(guessNumbers);
    }
}
