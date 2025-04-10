package Prova.EscolaTi.dto;

import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.entities.TipoItem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemMagicoDto {
    private Long id;
    private String nome;
    @Enumerated(value = EnumType.STRING)
    private TipoItem tipoItem;
    private int forca;
    private int defesa;

    public ItemMagicoDto (ItemMagico entity){
        BeanUtils.copyProperties(entity, this);
    }
}
