package com.example.desafio_tecnico_backend.controllers;

import com.example.desafio_tecnico_backend.interfaces.AgendamentoService;
import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import com.example.desafio_tecnico_backend.response.DefaultResponseTemplate;
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
    public ResponseEntity<String> AgendarMensagem(@Valid @RequestBody CriaAgendamentoRequest request){
        agendamentoService.AgendarMensagem(request);
        return ResponseEntity.ok("Mensagem Agendada");
    }

    @GetMapping(value = "/status/{id}")
    public ResponseEntity<DefaultResponseTemplate> ConsultaStatusAgendamento(@PathVariable UUID id)
    {
        var response = agendamentoService.ConsultaStatus(id);

        if(response.Status != HttpStatus.OK)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        return ResponseEntity.ok(response);
    }
}
