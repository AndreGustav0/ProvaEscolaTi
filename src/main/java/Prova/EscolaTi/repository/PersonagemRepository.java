package Prova.EscolaTi.repository;

import Prova.EscolaTi.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonagemRepository extends JpaRepository <Personagem, UUID> {
}
