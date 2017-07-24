package com.blinov.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanya on 21.07.2017.
 */
@Component
public class ModelImpl implements Model {

    private List<Integer> attempts;
    private Integer secretNumber;
    private int minRange;
    private int maxRange;
    private boolean won;

    @PostConstruct
    private void init() {
        won = false;
        attempts = new ArrayList<>();
    }

    public boolean isWon() { return won; }

    public List<Integer> getAttempts() {
        return attempts;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public int getMinRange() { return minRange; }

    public int getMaxRange() { return maxRange; }

    public void setWon(boolean won) { this.won = won; }

    public void setSecretNumber(Integer number) { this.secretNumber = number; }

    public void setAttempts(List<Integer> attempts) {
        this.attempts = attempts;
    }

    public void addAttempt(Integer attempt) {
        this.attempts.add(attempt);
    }

    public void setMinRange(Integer minRange) { this.minRange = minRange; }

    public void setMaxRange(Integer maxRange) { this.maxRange = maxRange; }
}
