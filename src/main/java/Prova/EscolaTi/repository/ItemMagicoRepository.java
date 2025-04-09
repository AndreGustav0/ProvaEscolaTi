package Prova.EscolaTi.repository;

import Prova.EscolaTi.entities.ItemMagico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemMagicoRepository extends JpaRepository <ItemMagico, UUID> {
}
