package br.com.acmepay.adapters.output.queue;

import br.com.acmepay.adapters.response.DocumentResponse;

public interface ProducerMessage {
    void publish(String queue,  String message);
}