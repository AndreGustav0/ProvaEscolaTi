package Prova.EscolaTi.dto;

import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.entities.Personagem;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonagemDtoSaida {
    private long id;
    private String nomePersonagem;
    private List<ItemMagico> itensMagicos;

    public PersonagemDtoSaida (Personagem personagem){
        BeanUtils.copyProperties(personagem, this);
    }
}


