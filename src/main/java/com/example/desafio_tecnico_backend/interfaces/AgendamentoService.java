package com.example.desafio_tecnico_backend.interfaces;

import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import com.example.desafio_tecnico_backend.response.DefaultResponseTemplate;

import java.util.UUID;

public interface AgendamentoService {
    void AgendarMensagem(CriaAgendamentoRequest request);

    DefaultResponseTemplate ConsultaStatus(UUID Id);
}
