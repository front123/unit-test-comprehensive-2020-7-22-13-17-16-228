package game;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GuessNumberGame {

    private int[] answer;

    public GuessNumberGame() {
    }

    public GuessNumberGame(INumberGenerator numberGenerator) {
        this.answer = numberGenerator.generate();
    }

    public String guess(int[] guessNumbers) {
        int countNumberInAnswerAndPositionCorrect = countNumberInAnswerAndPositionCorrect(guessNumbers);
        int countNumberInAnswerButWrongPosition = countNumberInAnswer(guessNumbers) - countNumberInAnswerAndPositionCorrect;
        return String.format("%dA%dB", countNumberInAnswerAndPositionCorrect, countNumberInAnswerButWrongPosition);
    }

    private int countNumberInAnswerAndPositionCorrect(int[] guessNumbers){
        long count = IntStream.range(0, answer.length)
                .mapToObj(i -> guessNumbers[i]==answer[i]).filter(isTrue -> isTrue).count();
        return (int) count;
    }
    private int countNumberInAnswer(int[] guessNumbers){
        long c2 = Arrays.stream(answer).filter(n1 -> Arrays.stream(guessNumbers).anyMatch(n2 -> n1==n2)).count();
        return (int) c2;
    }

    public int[] getAnswer() {
        return answer;
    }
}
