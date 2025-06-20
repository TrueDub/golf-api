package com.castlemon.golf.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Integer id) {
        super("Could not find course " + id);
    }
}