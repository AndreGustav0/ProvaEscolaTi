package Prova.EscolaTi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_itemMagico")
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private TipoItem tipoItem;
    private int forca;
    private int defesa;
}
