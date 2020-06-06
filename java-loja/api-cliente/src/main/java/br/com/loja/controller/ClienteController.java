package br.com.loja.controller;

import br.com.loja.constant.Constants;
import br.com.loja.model.Cliente;
import br.com.loja.service.ClienteServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {
    
    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteServico clienteService;

    @PostMapping(Constants.API_CLIENTE)
    public Cliente save(@RequestBody Cliente cliente){
        
        return clienteService.save(cliente);
    }

    @GetMapping(Constants.API_CLIENTE)
    public List<Cliente> findAll(){
        log.info("cliente");
        return clienteService.findAll();
    }

    @PutMapping(Constants.API_CLIENTE)
    public Cliente update(@RequestBody Cliente cliente){
        return this.save(cliente);
    }

    @DeleteMapping(Constants.API_CLIENTE + "/{id}")
    public void delete(@PathVariable("id") int id){
        clienteService.delete(id);
    }

    @GetMapping(Constants.API_CLIENTE + "/{id}")
    public Optional<Cliente> findById(@PathVariable("id") int id){
        return clienteService.findById(id);
    }
}
