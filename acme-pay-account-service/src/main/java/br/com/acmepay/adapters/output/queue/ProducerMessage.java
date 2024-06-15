package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.request.DocumentRequest;
import org.springframework.amqp.core.Message;

public interface ProducerMessage {
    void publish(String message);
}