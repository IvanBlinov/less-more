package com.blinov.controller;

import com.blinov.model.Model;
import com.blinov.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by vanya on 21.07.2017.
 */
@Component
public class ControllerImpl implements Controller{

    @Autowired private Model model;
    @Autowired private View view;

    public void processHandle() {
        greetings();
        scanForNumbers();
        playGame();
    }

    private void playGame() {
        model.setSecretNumber(getRandom(model.getMinRange(), model.getMaxRange()));
        Scanner sc = new Scanner(System.in);
        Integer current;
        while (!model.isWon()) {
            view.printMove(model.getMinRange(), model.getMaxRange(), model.getCountOfAttempts(), model.getAttempts());
            if (sc.hasNextInt()) {
                current = sc.nextInt();
            } else {
                view.printMessage(View.WRONG_INPUT);
                break;
            }
            switch (checkForWin(current)) {
                case 0 : {
                    model.setWon(true);
                    break;
                }
                case 1 : {
                    view.printMessage(View.LESS);
                    break;
                }
                case -1 : {
                    view.printMessage(View.MORE);
                    break;
                }
            }
            model.incrementCountOfAttempts();
            model.addAttempt(current);
        }
        view.printWinningMessage(model.getSecretNumber(), model.getCountOfAttempts(), model.getAttempts());
    }

    private int checkForWin(Integer number) {
        if (number == model.getSecretNumber()) { return 0; }
        if (number < model.getSecretNumber()) { return -1; }
        return 1;
    }

    private void scanForNumbers() {
        Integer min = null, max = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while(max == null && (line = reader.readLine()).length() > 0) {
                String[] words = line.split(" ");
                for (String word : words) {
                    try {
                        Integer number = Integer.parseInt(word);
                        if (min == null) {
                            min = number;
                        } else if (max == null) {
                            if (number > min) {
                                max = number;
                            } else {
                                min = null;
                                view.printMessage(View.WRONG_NUMBERS);
                            }
                        }
                    } catch (NumberFormatException ex) {
                        min = null;
                        view.printMessage(View.WRONG_INPUT);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.setMinRange(min == null ? 0 : min);
        model.setMaxRange(max == null ? Model.RAND_MAX : max);
    }

    private int getRandom(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    private void greetings() {
        view.printMessage(View.GREETINGS);
    }
}
