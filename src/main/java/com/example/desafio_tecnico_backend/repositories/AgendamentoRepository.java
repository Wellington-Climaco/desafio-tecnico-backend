package com.example.desafio_tecnico_backend.repositories;

import com.example.desafio_tecnico_backend.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,String> {
}
