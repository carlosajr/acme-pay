package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.request.DocumentRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String message) {
        log.info("Publishing : Payload {} / Queue {}", message, "queue_check_document");
        this.rabbitTemplate.convertAndSend("queue_check_document", message);
        log.info("Published : Payload {} / Queue {}", message, "queue_check_document");

    }
}