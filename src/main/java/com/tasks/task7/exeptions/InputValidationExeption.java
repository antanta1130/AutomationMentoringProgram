package com.tasks.task7.exeptions;

public class InputValidationExeption extends RuntimeException {
    public InputValidationExeption(String message) {
        super(message);
    }
}
