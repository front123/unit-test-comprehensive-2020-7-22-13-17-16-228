package game;

public class GameProcess {
    private final InputValidator inputValidator;
    private final GuessNumberGame guessNumberGame;
    private final TimesLimiter timesLimiter;
    public GameProcess() {
        this.guessNumberGame = new GuessNumberGame();
        this.inputValidator = new InputValidator();
        this.timesLimiter = new TimesLimiter(6);
    }

    public String play(int[] guessNumbers) throws TimesOutException {
        if (!inputValidator.isValidNumbers(guessNumbers)) {
            return "Wrong Input，Input again";
        }
        timesLimiter.increase();
        return guessNumberGame.guess(guessNumbers);
    }
}
