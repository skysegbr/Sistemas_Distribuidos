package br.com.loja.controller;

import br.com.loja.constant.Constants;
import br.com.loja.model.Fornecedor;
import br.com.loja.service.FornecedorServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FornecedorController {
    
    private static final Logger log = LoggerFactory.getLogger(FornecedorController.class);

    @Autowired
    private FornecedorServico fornecedorService;

    @PostMapping(Constants.API_FORNECEDOR)
    public Fornecedor save(@RequestBody Fornecedor fornecedor){
        
        return fornecedorService.save(fornecedor);
    }

    @GetMapping(Constants.API_FORNECEDOR)
    public List<Fornecedor> findAll(){
        log.info("cliente");
        return fornecedorService.findAll();
    }

    @PutMapping(Constants.API_FORNECEDOR)
    public Fornecedor update(@RequestBody Fornecedor fornecedor){
        return this.save(fornecedor);
    }

    @DeleteMapping(Constants.API_FORNECEDOR + "/{id}")
    public void delete(@PathVariable("id") int id){
        fornecedorService.delete(id);
    }

    @GetMapping(Constants.API_FORNECEDOR + "/{id}")
    public Optional<Fornecedor> findById(@PathVariable("id") int id){
        return fornecedorService.findById(id);
    }
}
