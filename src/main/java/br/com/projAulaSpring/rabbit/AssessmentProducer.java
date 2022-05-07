package br.com.projAulaSpring.rabbit;

import br.com.projAulaSpring.model.Assessment;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssessmentProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Assessment assessment){
        rabbitTemplate.convertAndSend(this.queue.getName(), assessment);
    }
}