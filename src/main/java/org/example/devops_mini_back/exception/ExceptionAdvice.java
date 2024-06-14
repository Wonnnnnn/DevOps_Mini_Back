package org.example.devops_mini_back.exception;

import org.example.devops_mini_back.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

import java.nio.file.NotLinkException;

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
    @ExceptionHandler(NotLinkException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> NoldExistsExceptionAdvice(NotLinkException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }
    @ExceptionHandler(DuplicateNameException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> DuplicateNameExceptionAdvice(DuplicateNameException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }
}
