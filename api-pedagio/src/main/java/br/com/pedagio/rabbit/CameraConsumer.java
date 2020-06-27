package br.com.pedagio.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.pedagio.model.CameraEntity;
import br.com.pedagio.service.CameraService;

@Component
public class CameraConsumer {
    @Autowired
    private CameraService cameraService;

    @RabbitListener(queues = {"${queue.can.name}"})
    public void receive (@Payload CameraEntity CameraEntity){
        System.out.println("Id: "+ CameraEntity.getId() + "\nImage: " + CameraEntity.getImage());
        cameraService.save(CameraEntity);
    }
}