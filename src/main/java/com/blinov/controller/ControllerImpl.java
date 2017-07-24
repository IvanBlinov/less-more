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
        view.printMessage(View.GUESS);
        Scanner sc = new Scanner(System.in);
        Integer current;
        while (!model.isWon()) {
            view.printMove(model.getMinRange(), model.getMaxRange(), model.getAttempts().size(), model.getAttempts());
            if (sc.hasNextInt()) {
                current = sc.nextInt();
                makeMove(current);
            } else {
                view.printMessage(View.WRONG_INPUT);
                sc.next();
            }
        }
        view.printWinningMessage(model.getSecretNumber(), model.getAttempts().size(), model.getAttempts());
    }

    private void makeMove(Integer current) {
        if (model.getSecretNumber() == current) {
            model.setWon(true);
        } else if (model.getSecretNumber() > current) {
            view.printMessage(View.MORE);
            model.setMinRange(current);
        } else {
            view.printMessage(View.LESS);
            model.setMaxRange(current);
        }
        model.addAttempt(current);
    }

    private void scanForNumbers() {
        Integer min = null, max = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while(max == null && (line = reader.readLine()).length() > 0) {
                String[] words = line.split(" ");
                for (String word : words) {
                    Integer number = getInt(word);
                    if (number == null) {
                        min = null;
                        view.printMessage(View.WRONG_INPUT);
                    } else {
                        if (min == null) {
                            min = number;
                        } else {
                            if (number > min) {
                                max = number;
                            } else {
                                min = null;
                                view.printMessage(View.WRONG_NUMBERS);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.setMinRange(min == null ? 0 : min);
        model.setMaxRange(max == null ? Model.RAND_MAX : max);
    }

    private Integer getInt(String word) {
        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private int getRandom(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    private void greetings() {
        view.printMessage(View.GREETINGS);
    }
}
