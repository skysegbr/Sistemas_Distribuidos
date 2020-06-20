package br.com.pedagio.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.pedagio.model.CameraEntity;
import br.com.pedagio.rabbit.CameraProducer;
import br.com.pedagio.repository.CameraRepository;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    @Autowired
    private CameraProducer cameraProducer;

    public void sendImageRabbit(CameraEntity can){
        cameraProducer.send(can);
    }

    public void save(CameraEntity can){
        cameraRepository.save(can);
    }

    public Optional<CameraEntity> findById(int id){
        return cameraRepository.findById(id);
    }

    public void deleteAll(){
        cameraRepository.deleteAll();
    }
    
}