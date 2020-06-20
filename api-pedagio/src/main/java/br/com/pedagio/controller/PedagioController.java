package br.com.pedagio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.pedagio.constant.Constants;
import br.com.pedagio.model.CameraEntity;
import br.com.pedagio.model.TransponderEntity;
import br.com.pedagio.service.CameraService;
import br.com.pedagio.service.TransponderService;
import java.util.Optional;

@RestController
public class PedagioController {

    @Autowired
    private TransponderService transponderService;

    @PostMapping(Constants.API_TRANSPONDER)
    public void save(@RequestBody TransponderEntity tag){
        transponderService.sendTagRabbit(tag);
    }

    @GetMapping(Constants.API_TRANSPONDER + "/{id}")
    public Optional<TransponderEntity> findById(@PathVariable("id") String id){
        return transponderService.findById(id);
    }

    @Autowired
    private CameraService cameraService;

    @PostMapping(Constants.API_CAMERA)
    public void save(@RequestBody CameraEntity can){
        cameraService.sendImageRabbit(can);
    }

    @GetMapping(Constants.API_CAMERA + "/{id}")
    public Optional<CameraEntity> findById(@PathVariable("id") int id){
        return cameraService.findById(id);
    }
}
