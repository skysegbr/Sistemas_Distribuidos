package br.com.pedagio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {

    @Value("${queue.tag.name}")
    private String tagQueue;

    @Value("${queue.can.name}")
    private String canQueue;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public Queue queueTag(){
        return new Queue(tagQueue, true);
    }

    @Bean
    public Queue queueCan(){
        return new Queue(canQueue, true);
    }
}