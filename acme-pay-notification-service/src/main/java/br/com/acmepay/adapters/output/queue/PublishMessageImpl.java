package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.response.DocumentResponse;
import br.com.acmepay.application.enums.DocumentStatus;
import br.com.acmepay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publish(String queue,  String message) {
        log.info("Publishing : Payload {} / Queue {}", message, queue);

        this.rabbitTemplate.convertAndSend(queue, message);

        log.info("Published : Payload {} / Queue {}", message, queue);

    }
}