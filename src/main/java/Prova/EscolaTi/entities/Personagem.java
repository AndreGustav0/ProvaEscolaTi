package Prova.EscolaTi.entities;

import Prova.EscolaTi.dto.PersonagemDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "tb_personagem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nomePersonagem;

    @Enumerated(EnumType.STRING)
    private Classe classe;

    private int level;

    @OneToMany
    private List<ItemMagico> itemMagico;
    @OneToOne
    private ItemMagico amuleto;

    private int forca;
    private int defesa;

    public Personagem (PersonagemDto dto){
        BeanUtils.copyProperties(dto, this);
    }
}
