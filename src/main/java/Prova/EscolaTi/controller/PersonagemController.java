package Prova.EscolaTi.controller;

import Prova.EscolaTi.dto.PersonagemDto;
import Prova.EscolaTi.dto.PersonagemDtoEntrada;
import Prova.EscolaTi.dto.PersonagemDtoSaida;
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
    public PersonagemDto listarPorId(@PathVariable long id){
        return personagemService.listarPorId(id);
    }

    @GetMapping
    public List<PersonagemDto> listarTodos(){
        return personagemService.listarTodos();
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable long id, @RequestBody PersonagemDtoEntrada dtoEntrada){
        personagemService.editar(id, dtoEntrada);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable long id){
        personagemService.excluir(id);
    }

    @PutMapping("/{personagemId}/adiciona-item-magico/{itemId}")
    public void adicionaItem(@PathVariable long personagemId, @PathVariable long itemId){
        personagemService.adicionaItem(personagemId,itemId);
    }

    @PutMapping("/{personagemId}/remove-item-magico/{itemId}")
    public void removeItem(@PathVariable long personagemId, @PathVariable long itemId){
        personagemService.removerItem(personagemId,itemId);
    }

    @GetMapping("/{id}/lista-de-itens")
    public PersonagemDtoSaida listaDeItens(@PathVariable long id){
        return personagemService.listaDeItens(id);
    }

    @GetMapping("/{id}/amuleto")
    public PersonagemDtoSaida amuletoPersonagem(@PathVariable long id){
        return  personagemService.amuletoPersonagem(id);
    }
}
