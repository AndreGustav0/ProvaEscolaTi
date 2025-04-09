package Prova.EscolaTi.service;

import Prova.EscolaTi.entities.ItemMagico;
import Prova.EscolaTi.entities.TipoItem;
import Prova.EscolaTi.repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    public ItemMagico criarItem(ItemMagico itemMagico){
        if(itemMagico.getTipoItem() == TipoItem.ARMADURA && itemMagico.getForca() > 0 || itemMagico.getDefesa() > 10
                || itemMagico.getTipoItem() == TipoItem.ARMA && itemMagico.getDefesa() > 0 || itemMagico.getForca() > 10
                || itemMagico.getTipoItem() == TipoItem.AMULETO && itemMagico.getDefesa() + itemMagico.getForca() > 10){
            throw new IllegalArgumentException("Atributo incompativel com o Tipo do Item ou superior a 10 pontos.");
        }
        return itemMagicoRepository.save(itemMagico);
    }
}
