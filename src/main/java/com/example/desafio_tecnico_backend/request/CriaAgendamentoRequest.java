package com.example.desafio_tecnico_backend.request;

import com.example.desafio_tecnico_backend.entities.Agendamento;
import com.example.desafio_tecnico_backend.enums.TipoEnvio;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
public class CriaAgendamentoRequest {

    @NotNull(message = "DataHora não pode ser nulo.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    public Date DataHora;

    @NotBlank(message = "Destinatario não pode ser vazio.")
    public String Destinatario;

    @NotBlank (message = "Mensagem não pode ser vazia.")
    public String Mensagem;

    @NotBlank (message = "Envio não pode ser vazio.")
    @Pattern(regexp = "WHATSAPP|SMS|EMAIL", message = "Tipo de notificação inválido. Valores permitidos: WHATSAPP, SMS e EMAIL.")
    public String Envio;

    public Agendamento MapToEntity(){
        var entity = new Agendamento(this.DataHora,this.Destinatario,this.Mensagem,TipoEnvio.valueOf(Envio));
        return entity;
    }
}
