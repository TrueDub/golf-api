package com.castlemon.golf.advice;

import com.castlemon.golf.exception.CourseNotFoundException;
import com.castlemon.golf.exception.RoundNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class CourseNotFoundAdvice {

    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String courseNotFoundHandler(CourseNotFoundException ex) {
        return ex.getMessage();
    }
}
