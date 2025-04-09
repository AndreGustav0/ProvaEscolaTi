package Prova.EscolaTi.dto;

import Prova.EscolaTi.entities.Classe;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonagemDto {
    private UUID id;
    private String nome;
    private String nomePersonagem;
    @Enumerated(EnumType.STRING)
    private Classe classe;
    private int level;
    private List<String> itemMagico;
    private int forca;
    private int defesa;
}
