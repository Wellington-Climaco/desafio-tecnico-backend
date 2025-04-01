package com.example.desafio_tecnico_backend.entities;


import com.example.desafio_tecnico_backend.enums.StatusEnvio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import com.example.desafio_tecnico_backend.enums.TipoEnvio;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Agendamento")
public class Agendamento {

    @Id
    public UUID id;
    public Date dataHora;
    public String destinatario;
    public String mensagem;
    public String tipoEnvio;
    public String status;

    public Agendamento(Date DataHora, String Destinatario, String Mensagem,TipoEnvio envio){
        this.id = UUID.randomUUID();
        this.dataHora = DataHora;
        this.destinatario = Destinatario;
        this.mensagem = Mensagem;
        this.tipoEnvio = envio.toString();
        this.status = StatusEnvio.PENDENTE.toString();
    }


}
