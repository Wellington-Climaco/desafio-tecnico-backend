package com.example.desafio_tecnico_backend.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class AgendamentoResponse {
    public UUID id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Date dataHora;
    public String destinatario;
    public String mensagem;
    public String tipoEnvio;
    public String status;
}
