package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.ProducerMessage;
import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CheckDocumentCustomerService implements ICheckDocumentCustomer {

    private final ProducerMessage producerMessage;

    @Override
    public void execute(DocumentRequest request) {
        String message = JsonUtil.convertToJson(request);
        producerMessage.publish(message);
        log.info("Publish successfully to payload {}" , request);
    }
}