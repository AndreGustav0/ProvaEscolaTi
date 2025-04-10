package Prova.EscolaTi.service;

import Prova.EscolaTi.dto.PersonagemDto;
import Prova.EscolaTi.dto.PersonagemDtoEntrada;
import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.entities.Personagem;
import Prova.EscolaTi.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

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

       if(personagem.getAmuleto() != null){
           forcaSomada += personagem.getAmuleto().getForca();
           defesaSomada += personagem.getAmuleto().getDefesa();
       }

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
       //Colocar List<ItemMagico> e Amuleto ?
       dto.setForca(forcaSomada);
       dto.setDefesa(defesaSomada);

       return dto;
    }

    public List<PersonagemDto> listarTodos(){
        List<Personagem> personagens = personagemRepository.findAll();
        return personagens.stream().map(PersonagemDto::new).toList();
    }
}
