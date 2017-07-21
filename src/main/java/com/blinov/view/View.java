package com.blinov.view;

import java.util.List;

/**
 * Created by vanya on 21.07.2017.
 */
public interface View {

    String GREETINGS = "Hello, please input the range (min and max) of random number:";
    String WRONG_INPUT = "Your input is wrong, please input the number";
    String WRONG_NUMBERS = "Max number should be more than min";
    String MORE = "-----------------More---------------------";
    String LESS = "-----------------Less---------------------";

    void printMessage(String message);
    void printWinningMessage(Integer secretNumber, Integer countOfAttempts, List<Integer> attempts);
    void printMove(Integer min, Integer max, Integer countOfAttempts, List<Integer> attempts);
}
