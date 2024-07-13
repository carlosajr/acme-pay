package br.com.acmepay.adapters.output.queue.rabbitmq;

import br.com.acmepay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProducerMessage implements IProducerMessage {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public <T> void publish(T message) {
        log.info("[RABBITMQ] Publishing: Queue {} | Payload {}", ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT, message);
        this.rabbitTemplate.convertAndSend(ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT, message);
        log.info("[RABBITMQ] Published");
    }
}
