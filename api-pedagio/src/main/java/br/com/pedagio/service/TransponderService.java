package br.com.pedagio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pedagio.model.TransponderEntity;
import br.com.pedagio.rabbit.TransponderProducer;
import br.com.pedagio.repository.TransponderRepository;

import java.util.Optional;

@Service
public class TransponderService {

    @Autowired
    private TransponderRepository transponderRepository;

    @Autowired
    private TransponderProducer pedagioProducer;

    public void sendTagRabbit(TransponderEntity tag){
        pedagioProducer.send(tag);
    }

    public void save(TransponderEntity tag){
        transponderRepository.save(tag);
    }

    public Optional<TransponderEntity> findById(String id){
        return transponderRepository.findById(id);
    }

    public void deleteAll(){
        transponderRepository.deleteAll();
    }

}
