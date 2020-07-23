package game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {

    public int[] generate() {
        List<Integer> numbersList = new LinkedList<>();
        int[] answerNumbers = new int[4];
        int index = 0;
        while (numbersList.size()<4){
            Random rd = new Random();
            int number = rd.nextInt(10);
            if(!numbersList.contains(number)){
                numbersList.add(number);
                answerNumbers[index] = number;
                index++;
            }
        }

        return answerNumbers;
    }
}
