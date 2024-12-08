package ru.skypro.Coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceedingNumberQuestionsException extends RuntimeException {

    public ExceedingNumberQuestionsException(String message) {
        super(message);
    }
}
