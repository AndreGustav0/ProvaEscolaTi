package Prova.EscolaTi.dto;

import Prova.EscolaTi.entities.Classe;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonagemDtoEntrada {
    private String nome;
    private String nomePersonagem;
    private Classe classe;
    private int level;
    private int forca;
    private int defesa;
}
