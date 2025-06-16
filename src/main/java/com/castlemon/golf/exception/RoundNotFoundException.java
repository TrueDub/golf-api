package com.castlemon.golf.exception;

public class RoundNotFoundException  extends RuntimeException {

    public RoundNotFoundException(Integer id) {
        super("Could not find round " + id);
    }
}