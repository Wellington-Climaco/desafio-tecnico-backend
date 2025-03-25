package com.example.desafio_tecnico_backend.interfaces;

import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;

public interface AgendamentoService {
    void AgendarMensagem(CriaAgendamentoRequest request);
}
