package br.com.acmepay.adapters.output.queue.kafka.producer;

public interface IMessageProducer {
    <T> void send(String topic, T message);
}