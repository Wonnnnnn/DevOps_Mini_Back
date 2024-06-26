package org.example.devops_mini_back.exception;

import org.example.devops_mini_back.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.nio.file.NotLinkException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionAdvice {
    private final View error;

    public ExceptionAdvice(View error) {
        this.error = error;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> illegalArgumentExceptionAdvice(IllegalArgumentException e) {
        return new Response("fail",e.getMessage().toString(), null);
    }
    @ExceptionHandler(ValidationCheckException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> ValidationCheckExceptionAdvice(ValidationCheckException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }

    @ExceptionHandler(NoIdExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> NoIdExistsExceptionAdvice(NoIdExistsException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }

    @ExceptionHandler(DuplicateNameException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> DuplicateNameExceptionAdvice(DuplicateNameException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> NoSuchElementExceptionAdvice(NoSuchElementException e) {
        return new Response("fail", "해당하는 값이 없습니다.", null);
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> AlreadyExistExceptionAdvice(AlreadyExistException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }
}
