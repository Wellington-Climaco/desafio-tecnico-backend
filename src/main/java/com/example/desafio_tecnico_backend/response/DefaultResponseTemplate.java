package com.example.desafio_tecnico_backend.response;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
public class DefaultResponseTemplate<T> {
    public HttpStatus Status;
    public T Message;
    public List<String> Errors;
}
