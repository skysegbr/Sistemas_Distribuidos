package br.com.pedagio.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.pedagio.model.CameraEntity;

@Component
public class CameraProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(CameraEntity can){
        rabbitTemplate.convertAndSend(this.queue.getName(), can);
    }
}