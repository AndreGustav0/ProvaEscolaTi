package Prova.EscolaTi.controller;

import Prova.EscolaTi.service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itensMagicos")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;


}
