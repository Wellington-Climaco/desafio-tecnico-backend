package com.example.desafio_tecnico_backend.controllers;

import com.example.desafio_tecnico_backend.interfaces.AgendamentoService;
import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import com.example.desafio_tecnico_backend.response.defaultResponse.DefaultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    @PostMapping(value = "/create")
    public ResponseEntity<DefaultResponse> AgendarMensagem(@Valid @RequestBody CriaAgendamentoRequest request){
        var response = agendamentoService.AgendarMensagem(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/status/{id}")
    public ResponseEntity<DefaultResponse> ConsultaStatusAgendamento(@PathVariable String id)
    {
        var response = agendamentoService.ConsultaStatus(id);

        if(response.status.code != HttpStatus.OK.value())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/cancelar/{id}")
    public ResponseEntity<DefaultResponse> CancelarAgendamento(@PathVariable String id){
        var response = agendamentoService.CancelarAgendamento(id);

        if(response.status.message.toLowerCase().equals("error"))
        {
            return ResponseEntity.status(response.status.code).body(response);
        }

        return ResponseEntity.ok(response);
    }
}
