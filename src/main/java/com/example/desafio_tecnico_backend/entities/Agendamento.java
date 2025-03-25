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
    public String Id;
    public Date DataHora;
    public String Destinatario;
    public String Mensagem;
    public String TipoEnvio;
    public String Status;

    public Agendamento(Date DataHora, String Destinatario, String Mensagem,TipoEnvio envio){
        this.Id = UUID.randomUUID().toString();
        this.DataHora = DataHora;
        this.Destinatario = Destinatario;
        this.Mensagem = Mensagem;
        this.TipoEnvio = envio.toString();
        this.Status = StatusEnvio.PENDENTE.toString();
    }


}
