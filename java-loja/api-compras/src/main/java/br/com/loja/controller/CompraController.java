package br.com.loja.controller;

import br.com.loja.constant.Constants;
import br.com.loja.model.Compra;
import br.com.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping(Constants.API_COMPRA)
    public Compra save(@RequestBody Compra compra){
        return compraService.save(compra);
    }

    @GetMapping(Constants.API_COMPRA)
    public List<Compra> findAll(){
        return compraService.findAll();
    }

    @PutMapping(Constants.API_COMPRA)
    public Compra update(@RequestBody Compra compra){
        return this.save(compra);
    }

    @DeleteMapping(Constants.API_COMPRA + "/{id}")
    public void delete(@PathVariable("id") int id){
        compraService.delete(id);
    }

    @GetMapping(Constants.API_COMPRA + "/{id}")
    public Optional<Compra> findById(@PathVariable("id") int id){
        return compraService.findById(id);
    }
}
