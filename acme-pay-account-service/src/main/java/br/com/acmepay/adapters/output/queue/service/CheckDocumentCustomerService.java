package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.rabbitmq.IProducerMessage;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.util.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckDocumentCustomerService implements ICheckDocumentCustomer {

    private final IProducerMessage producerMessage;

    @Override
    public void execute(DocumentRequest request) {
//        String message = JsonUtil.convertToJson(request);
        producerMessage.publish(request);
    }
}