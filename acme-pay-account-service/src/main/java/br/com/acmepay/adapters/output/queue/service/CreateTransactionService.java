package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.kafka.producer.IMessageProducer;
import br.com.acmepay.adapters.request.TransactionRequest;
import br.com.acmepay.application.ports.out.ICreateTransaction;
import br.com.acmepay.constants.ConstantsKafka;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTransactionService implements ICreateTransaction {

    private final IMessageProducer messageProducer;

    public void execute(TransactionRequest transactionRequest) {
        messageProducer.send(ConstantsKafka.TRANSACTIONS_TOPIC, transactionRequest);
    }
}
