package game;

public class GuessNumberGame {

    private int[] answer;

    public GuessNumberGame() {
    }

    public GuessNumberGame(INumberGenerator numberGenerator) {
        this.answer = numberGenerator.generate();
    }

    public String guess(int[] guessNumbers) {
        int countNumberInAnswerAndPositionCorrect = 0;
        int countNumberInAnswerButWrongPosition = 0;
        for (int i = 0; i < guessNumbers.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (guessNumbers[i] == answer[j] && i == j) {
                    countNumberInAnswerAndPositionCorrect++;
                    continue;
                }
                if (guessNumbers[i] == answer[j] && i != j) {
                    countNumberInAnswerButWrongPosition++;
                }
            }
        }

        return String.format("%dA%dB", countNumberInAnswerAndPositionCorrect, countNumberInAnswerButWrongPosition);
    }


    public int[] getAnswer() {
        return answer;
    }
}
