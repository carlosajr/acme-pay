package br.com.acmepay.adapters.output.queue.kafka.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MessageProducer implements IMessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public <T> void send(String topic, T message) {
        log.info("[KAFKA] Publishing: Topic {} | Payload {}", topic, message);
        kafkaTemplate.send(topic, message);  // Aqui enviamos o objeto diretamente
        log.info("[KAFKA] Published");
    }
}
