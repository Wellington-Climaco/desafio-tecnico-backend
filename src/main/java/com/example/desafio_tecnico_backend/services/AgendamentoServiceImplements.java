package com.example.desafio_tecnico_backend.services;

import com.example.desafio_tecnico_backend.interfaces.AgendamentoService;
import com.example.desafio_tecnico_backend.repositories.AgendamentoRepository;
import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import com.example.desafio_tecnico_backend.response.DefaultResponseTemplate;
import com.example.desafio_tecnico_backend.response.StatusAgendamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoServiceImplements implements AgendamentoService {
    private final AgendamentoRepository repository;

    @Override
    public void AgendarMensagem(CriaAgendamentoRequest request) {
        var entity = request.MapToEntity();

        repository.save(entity);
    }

    @Override
    public DefaultResponseTemplate ConsultaStatus(UUID Id) {
        var entity = repository.findById(Id).orElse(null);

        if(entity == null) {
            return new DefaultResponseTemplate(HttpStatus.NOT_FOUND, "Usuário não encontrado", null);
        }

        var statusResponse = new StatusAgendamentoResponse(entity.DataHora,entity.Status);
        return new DefaultResponseTemplate<StatusAgendamentoResponse>(HttpStatus.OK,statusResponse ,null);
    }
}
