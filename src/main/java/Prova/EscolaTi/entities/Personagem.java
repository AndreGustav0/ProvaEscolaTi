package Prova.EscolaTi.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_personagem")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String nomePersonagem;
    private Classe classe;
    private int level;
    private List<String> itemMagico;
    private int forca;
    private int defesa;
}
