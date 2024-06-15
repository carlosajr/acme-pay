package br.com.acmepay.adapters.input.queue;

public interface ConsumerMessage {
    void consume(String message);
}