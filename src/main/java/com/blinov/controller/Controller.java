package com.blinov.controller;

/**
 * Created by vanya on 21.07.2017.
 */
public interface Controller {

    void processHandle();
    int getRandom(int min, int max);
    int getRandom();
}
