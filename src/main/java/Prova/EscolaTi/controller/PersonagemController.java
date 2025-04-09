package Prova.EscolaTi.controller;

import Prova.EscolaTi.entities.Personagem;
import Prova.EscolaTi.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public Personagem criar(@RequestBody Personagem personagem){
        return personagemService.criar(personagem);
    }
}
