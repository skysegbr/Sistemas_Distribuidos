package br.com.pedagio.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.pedagio.model.TransponderEntity;

@Component
public class TransponderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(TransponderEntity tag){
        rabbitTemplate.convertAndSend(this.queue.getName(), tag);
    }
} 
