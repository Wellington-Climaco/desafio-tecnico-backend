package com.example.desafio_tecnico_backend.exceptions;

import com.example.desafio_tecnico_backend.response.defaultResponse.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResponse> ValidationHandlerException(MethodArgumentNotValidException ex)
    {
        var listErrors = ex.getBindingResult()
                        .getFieldErrors()
                        .stream().map(fieldError -> fieldError.getDefaultMessage())
                        .toList();
        var response = new DefaultResponse(HttpStatus.BAD_REQUEST.value(),"error",listErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AgendamentoNotFoundException.class)
    public ResponseEntity<DefaultResponse> NotFoundHandlerException(AgendamentoNotFoundException ex)
    {
        List<String> errors = List.of(ex.getMessage());
        var response = new DefaultResponse(HttpStatus.NOT_FOUND.value(),"error",errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(IdInvalidoException.class)
    public ResponseEntity<DefaultResponse> IdInvalidoExceptionHandlerException(IdInvalidoException ex)
    {
        List<String> errors = List.of(ex.getMessage());
        var response = new DefaultResponse(HttpStatus.BAD_REQUEST.value(),"error",errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
