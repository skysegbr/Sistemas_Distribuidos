package br.com.loja.service;

import br.com.loja.model.Produto;
import br.com.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(int id){
        return produtoRepository.findById(id);
    }
    
    public void delete(int id){
        produtoRepository.deleteById(id);
    }
}
