package br.com.loja.controller;

import br.com.loja.constant.Constants;
import br.com.loja.model.Produto;
import br.com.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(Constants.API_PRODUTO)
    public Produto save(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @GetMapping(Constants.API_PRODUTO)
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @PutMapping(Constants.API_PRODUTO)
    public Produto update(@RequestBody Produto produto){
        return this.save(produto);
    }

    @DeleteMapping(Constants.API_PRODUTO + "/{id}")
    public void delete(@PathVariable("id") int id){
        produtoService.delete(id);
    }

    @GetMapping(Constants.API_PRODUTO + "/{id}")
    public Optional<Produto> findById(@PathVariable("id") int id){
        return produtoService.findById(id);
    }
}
