package Prova.EscolaTi.entities;

import Prova.EscolaTi.dto.ItemMagicoDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "tb_itemMagico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @Enumerated(value = EnumType.STRING)
    private TipoItem tipoItem;
    private int forca;
    private int defesa;

    public ItemMagico (ItemMagicoDto dto){
        BeanUtils.copyProperties(dto, this);
    }
}
