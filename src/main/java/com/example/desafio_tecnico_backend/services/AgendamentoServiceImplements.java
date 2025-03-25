package com.example.desafio_tecnico_backend.services;

import com.example.desafio_tecnico_backend.interfaces.AgendamentoService;
import com.example.desafio_tecnico_backend.repositories.AgendamentoRepository;
import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoServiceImplements implements AgendamentoService {
    private final AgendamentoRepository repository;

    public AgendamentoServiceImplements(AgendamentoRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public void AgendarMensagem(CriaAgendamentoRequest request) {
        var entity = request.MapToEntity();

        repository.save(entity);
    }
}
