package Prova.EscolaTi.service;

import Prova.EscolaTi.entities.Personagem;
import Prova.EscolaTi.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
