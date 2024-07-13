package br.com.acmepay.adapters.output.queue.rabbitmq;

public interface IProducerMessage {
    <T> void publish(T message);
}