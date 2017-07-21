package com.blinov.view;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by vanya on 21.07.2017.
 */
@Component
public class ViewImpl implements View {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinningMessage(Integer secretNumber, Integer countOfAttempts, List<Integer> attempts) {
        System.out.print(String.format("Congratulations, you won!!\n" +
                                        "Your statistic:\n" +
                                        "The secret number is: %s\n" +
                                        "Count of your attempts: %s\n" +
                                        "Your attempts: ",
                                        secretNumber,countOfAttempts));
        attempts.forEach(attempt -> System.out.print(attempt + " "));
        printNewLine();
    }

    public void printMove(Integer min, Integer max, Integer countOfAttempts, List<Integer> attempts) {
        System.out.print(String.format("Diapason is: [%s..%s]\n" +
                                        "Your count of moves: %s\n" +
                                        "Your attempts: ",
                min,max,countOfAttempts));
        attempts.forEach(attempt -> System.out.print(attempt + " "));
        printMessage("\n-----------------------------------");
    }

    private void printNewLine() {
        System.out.println("");
    }
}
