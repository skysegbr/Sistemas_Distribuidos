package br.com.loja.service;

import br.com.loja.model.Cliente;
import br.com.loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> findById(int id){
        return clienteRepository.findById(id);
    }
    public void delete(int id){
        clienteRepository.deleteById(id);
    }
}
