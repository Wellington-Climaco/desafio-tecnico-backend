package com.example.desafio_tecnico_backend.services;

import com.example.desafio_tecnico_backend.enums.StatusEnvio;
import com.example.desafio_tecnico_backend.exceptions.AgendamentoNotFoundException;
import com.example.desafio_tecnico_backend.exceptions.IdInvalidoException;
import com.example.desafio_tecnico_backend.interfaces.AgendamentoService;
import com.example.desafio_tecnico_backend.repositories.AgendamentoRepository;
import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import com.example.desafio_tecnico_backend.response.AgendamentoResponse;
import com.example.desafio_tecnico_backend.response.StatusAgendamentoResponse;
import com.example.desafio_tecnico_backend.response.defaultResponse.DefaultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgendamentoServiceImplements implements AgendamentoService {
    private final AgendamentoRepository repository;

    @Override
    public DefaultResponse AgendarMensagem(CriaAgendamentoRequest request) {
        var entity = request.MapToEntity();

        repository.save(entity);
        var response = new AgendamentoResponse(entity.id,entity.dataHora,entity.destinatario,entity.mensagem,entity.tipoEnvio,entity.status);
        return new DefaultResponse(HttpStatus.OK.value(),"success",response);
    }

    @Override
    public DefaultResponse ConsultaStatus(String Id) {
        try{
            var ToUUID = UUID.fromString(Id);
            var entity = repository.findById(ToUUID).orElse(null);

            if(entity == null) {
                List<String> errors = List.of("Agendamento não encontrado");
                return new DefaultResponse(HttpStatus.NOT_FOUND.value(), "error", errors);
            }

            var statusResponse = new StatusAgendamentoResponse(entity.dataHora,entity.status);
            return new DefaultResponse(HttpStatus.OK.value(),"success",statusResponse);
        }
        catch (IllegalArgumentException e) {
            throw new IdInvalidoException("Formato do id está incorreto");
        }
    }

    @Override
    public DefaultResponse CancelarAgendamento(String Id) {
        try {
            var toUUID = UUID.fromString(Id);

            var entity = repository.findById(toUUID)
                    .orElseThrow(() -> new AgendamentoNotFoundException("Agendamento não encontrado"));

            if(entity.status.toLowerCase().equals(StatusEnvio.CANCELADO.toString().toLowerCase())) {
                List<String> errors = List.of("Agendamento já foi cancelado");
                var response = new DefaultResponse(HttpStatus.CONFLICT.value(),"error",errors);
                return response;
            }

            entity.status = StatusEnvio.CANCELADO.toString();
            repository.save(entity);

            var responseDto = new AgendamentoResponse(entity.id,entity.dataHora,entity.destinatario,entity.mensagem,entity.tipoEnvio,entity.status);
            var response = new DefaultResponse(HttpStatus.OK.value(),"success",responseDto);
            return response;

        } catch (IllegalArgumentException e) {
            throw new IdInvalidoException("Formato do id está incorreto");
        }
    }
}
