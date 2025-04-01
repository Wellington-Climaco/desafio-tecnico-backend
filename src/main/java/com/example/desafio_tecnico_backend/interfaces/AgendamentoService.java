package com.example.desafio_tecnico_backend.interfaces;

import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import com.example.desafio_tecnico_backend.response.defaultResponse.DefaultResponse;

import java.util.UUID;

public interface AgendamentoService {
    DefaultResponse AgendarMensagem(CriaAgendamentoRequest request);

    DefaultResponse ConsultaStatus(String Id);

    DefaultResponse CancelarAgendamento(String Id);
}
