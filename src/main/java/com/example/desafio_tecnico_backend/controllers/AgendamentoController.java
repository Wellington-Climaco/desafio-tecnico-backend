package com.example.desafio_tecnico_backend.controllers;

import com.example.desafio_tecnico_backend.interfaces.AgendamentoService;
import com.example.desafio_tecnico_backend.request.CriaAgendamentoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService){
        this.agendamentoService = agendamentoService;
    }
    @PostMapping(value = "/create")
    public ResponseEntity<String> AgendarMensagem(@RequestBody CriaAgendamentoRequest request){
        agendamentoService.AgendarMensagem(request);
        return ResponseEntity.ok("Mensagem Agendada");
    }
}
