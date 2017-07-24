package com.blinov.model;

import java.util.List;

/**
 * Created by vanya on 21.07.2017.
 */
public interface Model {

    int RAND_MAX = 200;

    boolean isWon();
    List<Integer> getAttempts();
    int getSecretNumber();
    int getMinRange();
    int getMaxRange();

    void setWon(boolean won);
    void addAttempt(Integer attempt);
    void setSecretNumber(Integer number);
    void setMinRange(Integer minRange);
    void setMaxRange(Integer maxRange);
}
