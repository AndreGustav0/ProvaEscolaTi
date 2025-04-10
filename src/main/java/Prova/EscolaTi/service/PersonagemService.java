package Prova.EscolaTi.service;

import Prova.EscolaTi.dto.PersonagemDto;
import Prova.EscolaTi.entities.Personagem;
import Prova.EscolaTi.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public Personagem criar(Personagem personagem){
        if(personagem.getForca() + personagem.getDefesa() > 10){
            throw new IllegalArgumentException("A soma da força e defesa não pode ser maior do que 10 pontos.");
        }
        return personagemRepository.save(personagem);
    }

    public PersonagemDto listarPorId(Long id){
       return new PersonagemDto(personagemRepository.findById(id).get());
    }

    public List<PersonagemDto> listarTodos(){
        List<Personagem> personagens = personagemRepository.findAll();
        return personagens.stream().map(PersonagemDto::new).toList();
    }
}
