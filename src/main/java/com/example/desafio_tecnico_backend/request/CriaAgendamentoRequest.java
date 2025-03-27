package com.example.desafio_tecnico_backend.request;

import com.example.desafio_tecnico_backend.entities.Agendamento;
import com.example.desafio_tecnico_backend.enums.TipoEnvio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
public class CriaAgendamentoRequest {

    @NotNull(message = "DataHora não pode ser nulo.")
    public Date DataHora;

    @NotBlank(message = "Destinatario não pode ser vazio.")
    public String Destinatario;

    @NotBlank (message = "Mensagem não pode ser vazia.")
    public String Mensagem;

    @NotBlank (message = "Envio não pode ser vazio.")
    public String Envio;

    public Agendamento MapToEntity(){
        var entity = new Agendamento(this.DataHora,this.Destinatario,this.Mensagem,TipoEnvio.valueOf(Envio));
        return entity;
    }
}
