package ru.rmanokhin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static StartProgram startProgram;

    @Autowired
    public void setStart(StartProgram startProgram) {
        Application.startProgram = startProgram;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        startProgram.start();

    }

}
