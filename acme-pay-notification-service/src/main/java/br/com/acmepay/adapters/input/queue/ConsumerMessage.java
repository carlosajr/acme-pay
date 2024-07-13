package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.request.DocumentRequest;

public interface ConsumerMessage {
    void consume(DocumentRequest documentRequest);
}