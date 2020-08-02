package game;

public class GameProcess {
    private final InputValidator inputValidator;
    private final GuessNumberGame guessNumberGame;
    private final TimesLimiter timesLimiter;
    private final AnswerGenerator answerGenerator;
    public GameProcess() {
        this.answerGenerator = new AnswerGenerator();
        this.guessNumberGame = new GuessNumberGame(answerGenerator);
        this.inputValidator = new InputValidator();
        this.timesLimiter = new TimesLimiter(6);
    }
    public GameProcess(GuessNumberGame guessNumberGame, InputValidator inputValidator, TimesLimiter timesLimiter) {
        this.guessNumberGame = guessNumberGame;
        this.inputValidator = inputValidator;
        this.timesLimiter = timesLimiter;
        this.answerGenerator = new AnswerGenerator();
    }

    public String play(int[] guessNumbers) throws TimesOutException {
        if (!inputValidator.isValidNumbers(guessNumbers)) {
            return "Wrong Input，Input again";
        }
        timesLimiter.increase();
        String xAxB = guessNumberGame.guess(guessNumbers);
        if (xAxB.equals("4A0B")){
            // todo
            return "Win";
        }
        return xAxB;
    }
}
