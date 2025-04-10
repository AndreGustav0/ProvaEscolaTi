package Prova.EscolaTi.controller;

import Prova.EscolaTi.dto.PersonagemDto;
import Prova.EscolaTi.dto.PersonagemDtoEntrada;
import Prova.EscolaTi.entities.Personagem;
import Prova.EscolaTi.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping
    public Personagem criar(@RequestBody PersonagemDtoEntrada personagem){
        return personagemService.criar(personagem);
    }

    @GetMapping("/{id}")
    public PersonagemDto listarPorId(@PathVariable Long id){
        return personagemService.listarPorId(id);
    }

    @GetMapping
    public List<PersonagemDto> listarTodos(){
        return personagemService.listarTodos();
    }
}
