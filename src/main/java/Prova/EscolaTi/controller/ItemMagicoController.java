package Prova.EscolaTi.controller;

import Prova.EscolaTi.dto.ItemMagicoDto;
import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itensMagicos")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping
    public ItemMagico criarItem(@RequestBody ItemMagico itemMagico){
        return itemMagicoService.criarItem(itemMagico);
    }

    @GetMapping()
    public List<ItemMagicoDto> buscarTodos(){
        return itemMagicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ItemMagicoDto buscarPorId(@PathVariable long id){
        return itemMagicoService.listarPorId(id);
    }
}
