package br.com.loja.service;

import br.com.loja.model.Venda;
import br.com.loja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda save(Venda compra){
        return vendaRepository.save(compra);
    }

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(int id){
        return vendaRepository.findById(id);
    }
    
    public void delete(int id){
        vendaRepository.deleteById(id);
    }
}
