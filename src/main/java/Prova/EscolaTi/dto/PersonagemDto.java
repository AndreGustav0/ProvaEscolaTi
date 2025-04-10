package Prova.EscolaTi.dto;

import Prova.EscolaTi.entities.Classe;
import Prova.EscolaTi.entities.Personagem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonagemDto {
    private Long id;
    private String nome;
    private String nomePersonagem;
    @Enumerated(EnumType.STRING)
    private Classe classe;
    private int level;
    private List<String> itemMagico;
    private int forca;
    private int defesa;

    public PersonagemDto(Personagem personagem){
        BeanUtils.copyProperties(personagem, this);
    }
}
