package Prova.EscolaTi.service;

import Prova.EscolaTi.dto.PersonagemDto;
import Prova.EscolaTi.dto.PersonagemDtoEntrada;
import Prova.EscolaTi.dto.PersonagemDtoSaida;
import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.entities.Personagem;
import Prova.EscolaTi.entities.TipoItem;
import Prova.EscolaTi.repository.ItemMagicoRepository;
import Prova.EscolaTi.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    public Personagem criar(PersonagemDtoEntrada dtoEntrada){
        if(dtoEntrada.getForca() + dtoEntrada.getDefesa() > 10){
            throw new IllegalArgumentException("A soma da força e defesa não pode ser maior do que 10 pontos.");
        }

        Personagem personagem = new Personagem();
        personagem.setNome(dtoEntrada.getNome());
        personagem.setNomePersonagem(dtoEntrada.getNomePersonagem());
        personagem.setClasse(dtoEntrada.getClasse());
        personagem.setLevel(dtoEntrada.getLevel());
        personagem.setForca(dtoEntrada.getForca());
        personagem.setDefesa(dtoEntrada.getDefesa());

        return personagemRepository.save(personagem);
    }

    public PersonagemDto listarPorId(Long id){
       Personagem personagem = personagemRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Personagem não encontrado."));

       int forcaSomada = personagem.getForca();
       int defesaSomada = personagem.getDefesa();

       if(personagem.getItemMagico() != null){
           for(int i=0; i < personagem.getItemMagico().size(); i++){
               ItemMagico item = personagem.getItemMagico().get(i);

               forcaSomada += item.getForca();
               defesaSomada += item.getDefesa();
           }
       }

       PersonagemDto dto = new PersonagemDto();
       dto.setId(personagem.getId());
       dto.setNome(personagem.getNome());
       dto.setNomePersonagem(personagem.getNomePersonagem());
       dto.setClasse(personagem.getClasse());
       dto.setLevel(personagem.getLevel());
       dto.setItemMagico(personagem.getItemMagico());
       dto.setForca(forcaSomada);
       dto.setDefesa(defesaSomada);

       return dto;
    }

    public List<PersonagemDto> listarTodos(){
        List<Personagem> personagens = personagemRepository.findAll();
        List<PersonagemDto> dtos = new ArrayList<>();

        for(int i=0; i< personagens.size(); i++){
            Personagem personagem = personagens.get(i);

            int forcaSomada = personagem.getForca();
            int defesaSomada = personagem.getDefesa();

            if(personagem.getItemMagico() != null){
                for(int x=0; x<personagem.getItemMagico().size(); x++){
                    ItemMagico item = personagem.getItemMagico().get(x);

                    forcaSomada += item.getForca();
                    defesaSomada += item.getDefesa();
                }
            }

            PersonagemDto dto = new PersonagemDto();
            dto.setId(personagem.getId());
            dto.setNome(personagem.getNome());
            dto.setNomePersonagem(personagem.getNomePersonagem());
            dto.setClasse(personagem.getClasse());
            dto.setLevel(personagem.getLevel());
            dto.setItemMagico(personagem.getItemMagico());
            dto.setForca(forcaSomada);
            dto.setDefesa(defesaSomada);

            dtos.add(dto);
        }
        return dtos;
    }

    public void editar(long id, PersonagemDtoEntrada dtoEntrada){
        Personagem personagem = personagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        personagem.setNome(dtoEntrada.getNome());
        personagem.setNomePersonagem(dtoEntrada.getNomePersonagem());

        personagemRepository.save(personagem);
    }

    public void excluir(long id){
        Personagem personagem = personagemRepository.findById(id).get();
        personagemRepository.delete(personagem);
    }

    public void adicionaItem (long personagemId, long itemId){
        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        ItemMagico item = itemMagicoRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item Mágico não encontrado"));

        boolean jaTemAmuleto = false;

        for(int i=0; i<personagem.getItemMagico().size(); i++){
            if(personagem.getItemMagico().get(i).getTipoItem() == TipoItem.AMULETO){
                jaTemAmuleto = true;
            }
        }

        if(item.getTipoItem().equals(TipoItem.AMULETO) && jaTemAmuleto){
            throw new IllegalArgumentException("Pesonagem já está com um Amuleto");
        }

        personagem.getItemMagico().add(item);
        personagemRepository.save(personagem);
    }

    public void removerItem(long personagemId, long itemId){
        Personagem personagem = personagemRepository.findById(personagemId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        ItemMagico item = itemMagicoRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item Mágico não encontrado"));

        if(personagem.getItemMagico() == null){
            throw new IllegalArgumentException("Pesonagem não tem nenhum item");
        }

        personagem.getItemMagico().remove(item);
        personagemRepository.save(personagem);
    }

    public PersonagemDtoSaida listaDeItens (long id){
        Personagem personagem = personagemRepository.findById(id).get();
        PersonagemDtoSaida dto = new PersonagemDtoSaida();

        dto.setId(personagem.getId());
        dto.setNomePersonagem(personagem.getNomePersonagem());
        dto.setItensMagicos(personagem.getItemMagico());

        return dto;
    }
}
