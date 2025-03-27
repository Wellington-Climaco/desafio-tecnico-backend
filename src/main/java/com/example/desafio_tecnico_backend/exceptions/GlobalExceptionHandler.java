package com.example.desafio_tecnico_backend.exceptions;

import com.example.desafio_tecnico_backend.response.DefaultResponseTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResponseTemplate> ValidationHandlerException(MethodArgumentNotValidException ex)
    {
        var listErrors = ex.getBindingResult()
                        .getFieldErrors()
                        .stream().map(fieldError -> fieldError.getDefaultMessage())
                        .toList();
        var response = new DefaultResponseTemplate(HttpStatus.BAD_REQUEST,"Erro",listErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
