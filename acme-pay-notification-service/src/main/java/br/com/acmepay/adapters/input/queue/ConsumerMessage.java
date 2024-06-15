package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.request.DocumentRequest;
import org.springframework.amqp.core.Message;

public interface ConsumerMessage {
    void consume(String message);
}