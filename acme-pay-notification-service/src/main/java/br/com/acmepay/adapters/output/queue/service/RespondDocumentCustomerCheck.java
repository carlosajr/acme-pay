package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.ProducerMessage;
import br.com.acmepay.adapters.response.DocumentResponse;
import br.com.acmepay.application.enums.DocumentStatus;
import br.com.acmepay.application.ports.out.IRespondDocumentCustomerCheck;
import br.com.acmepay.application.util.JsonUtil;
import br.com.acmepay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RespondDocumentCustomerCheck implements IRespondDocumentCustomerCheck {

    private final ProducerMessage producerMessage;

    @Override
    public void execute(DocumentResponse documentResponse) {
        var queue = documentResponse.getStatus().equals(DocumentStatus.ACTIVE)
                ? ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT_SUCCESS
                : ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT_FAIL;

        String message = JsonUtil.convertToJson(documentResponse);
        producerMessage.publish(queue, message);

        log.info("Publish successfully to payload {}" , message);
    }
}