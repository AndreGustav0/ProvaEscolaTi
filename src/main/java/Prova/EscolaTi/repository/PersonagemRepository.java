package Prova.EscolaTi.repository;

import Prova.EscolaTi.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository <Personagem, Long> {
}
