package br.com.pedagio.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.pedagio.model.TransponderEntity;
import br.com.pedagio.service.TransponderService;

@Component
public class TransponderConsumer {

    @Autowired
    private TransponderService pedagioService;

    @RabbitListener(queues = {"${queue.pedagio.name}"})
    public void receive (@Payload TransponderEntity transponderEntity){
        System.out.println("Id: "+ transponderEntity.getId() + "\nTag: " + transponderEntity.getTag());
        //Inserir dado no Mongo
        pedagioService.save(transponderEntity);
    }
} 
