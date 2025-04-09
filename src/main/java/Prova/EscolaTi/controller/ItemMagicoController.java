package Prova.EscolaTi.controller;

import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itensMagicos")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @PostMapping
    public ItemMagico criarItem(@RequestBody ItemMagico itemMagico){
        return itemMagicoService.criarItem(itemMagico);
    }
}
