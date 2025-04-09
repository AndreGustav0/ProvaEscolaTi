package Prova.EscolaTi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_itemMagico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemMagico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private TipoItem tipoItem;
    private int forca;
    private int defesa;
}
