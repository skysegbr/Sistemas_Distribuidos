package br.com.loja.service;

import br.com.loja.model.Compra;
import br.com.loja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra save(Compra compra){
        return compraRepository.save(compra);
    }

    public List<Compra> findAll(){
        return compraRepository.findAll();
    }

    public Optional<Compra> findById(int id){
        return compraRepository.findById(id);
    }
    
    public void delete(int id){
        compraRepository.deleteById(id);
    }
}
