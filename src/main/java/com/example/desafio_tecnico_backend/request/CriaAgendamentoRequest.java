package com.example.desafio_tecnico_backend.request;

import com.example.desafio_tecnico_backend.entities.Agendamento;
import com.example.desafio_tecnico_backend.enums.TipoEnvio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
public class CriaAgendamentoRequest {
    public Date DataHora;
    public String Destinatario;
    public String Mensagem;
    public String Envio;

    public Agendamento MapToEntity(){
        var entity = new Agendamento(this.DataHora,this.Destinatario,this.Mensagem,TipoEnvio.valueOf(Envio));
        return entity;
    }
}
