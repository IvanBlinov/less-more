package com.blinov;

import com.blinov.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Created by vanya on 21.07.2017.
 */
@SpringBootApplication
public class Application {

    @Autowired private Controller controller;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void init() {
        controller.processHandle();
    }
}
