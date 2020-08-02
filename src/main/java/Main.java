import game.GameProcess;
import game.TimesOutException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    private BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int[] input() throws IOException {
        System.out.println("------Please input guess number ------");
        String input = bufferedReader.readLine();
        String[] numberStrings = input.split(" ");
        if (isDigitalNumber(numberStrings)) {
            int[] guessNumbers = new int[4];
            int index = 0;
            for (String numberString : numberStrings) {
                guessNumbers[index++] = Integer.parseInt(numberString);
            }
            return guessNumbers;
        }
        System.out.println("Wrong Input，Input again");
        return null;
    }

    public boolean isDigitalNumber(String[] numberStrings) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return Arrays.stream(numberStrings)
                .filter(numberString -> pattern.matcher(numberString).matches())
                .count() == numberStrings.length;
    }

    public static void main(String[] args) throws IOException {
        GameProcess gameProcess = new GameProcess();
        Main main = new Main();
        while (true) {
            int[] guessNumbers = main.input();
            if (guessNumbers != null) {
                try {
                    String xAxB = gameProcess.play(guessNumbers);
                    if (xAxB.equals("4A0B")) {
                        System.out.println("You win!");
                        return;
                    }
                    System.out.println(xAxB);
                } catch (TimesOutException e) {
                    System.out.println("Game Over You failed!");
                    return;
                }
            }
        }

    }
}
