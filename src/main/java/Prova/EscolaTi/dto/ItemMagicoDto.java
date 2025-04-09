package Prova.EscolaTi.dto;

import Prova.EscolaTi.entities.TipoItem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemMagicoDto {
    private UUID id;
    private String nome;
    @Enumerated(value = EnumType.STRING)
    private TipoItem tipoItem;
    private int forca;
    private int defesa;
}
