package br.com.acmepay.adapters.input.queue.kafka.consumer;

import br.com.acmepay.adapters.request.TransactionRequest;
import br.com.acmepay.constants.ConstantsKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionRequestConsumer {

    @KafkaListener(topics = ConstantsKafka.TRANSACTIONS_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void consumeTransactionRequest(TransactionRequest transactionRequest) {
        log.info("Received Kafka message: {}", transactionRequest);
    }
}
