package br.com.loja.controller;

import br.com.loja.constant.Constants;
import br.com.loja.model.Venda;
import br.com.loja.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping(Constants.API_VENDA)
    public Venda save(@RequestBody Venda venda){
        return vendaService.save(venda);
    }

    @GetMapping(Constants.API_VENDA)
    public List<Venda> findAll(){
        return vendaService.findAll();
    }

    @PutMapping(Constants.API_VENDA)
    public Venda update(@RequestBody Venda venda){
        return this.save(venda);
    }

    @DeleteMapping(Constants.API_VENDA + "/{id}")
    public void delete(@PathVariable("id") int id){
        vendaService.delete(id);
    }

    @GetMapping(Constants.API_VENDA + "/{id}")
    public Optional<Venda> findById(@PathVariable("id") int id){
        return vendaService.findById(id);
    }
}
