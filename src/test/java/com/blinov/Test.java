package com.blinov;

import static org.junit.Assert.*;
import com.blinov.controller.Controller;
import com.blinov.model.Model;
import com.blinov.view.View;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vanya on 25.07.2017.
 */
public class Test {

    @Autowired Model model;
    @Autowired View view;
    @Autowired Controller controller;

    static String SUCCESS = "The test was successful";
    static String FAILURE = "The test has failed";

    @org.junit.Test
    public void checkInRange() {
        int secretNumber = controller.getRandom(5,50);
        assertTrue(secretNumber >= 5 && secretNumber <= 50);
    }

    @org.junit.Test
    public void checkDefaultRange() {
        int secretNumber = controller.getRandom();
        assertTrue(secretNumber > 0 && secretNumber < 200);
    }

    public static void main(String[] args) {
        JUnitCore testRunner = new JUnitCore();
        Result result = testRunner.run(Test.class);
        if (result.wasSuccessful()) {
            System.out.println(SUCCESS);
        } else {
            System.out.println(FAILURE);
        }
    }
}
