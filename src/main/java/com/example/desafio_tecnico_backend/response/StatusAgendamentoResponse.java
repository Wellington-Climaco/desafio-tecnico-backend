package com.example.desafio_tecnico_backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class StatusAgendamentoResponse {
    Date DataHora;
    String Status;
}
