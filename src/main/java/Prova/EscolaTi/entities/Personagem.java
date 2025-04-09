package Prova.EscolaTi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_personagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
