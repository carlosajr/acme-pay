package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.response.DocumentResponse;
import br.com.acmepay.application.util.JsonUtil;
import br.com.acmepay.application.util.memory.IMemoryDataUtil;
import br.com.acmepay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsumerDocumentResponseMessage implements ConsumerMessage {

    private final IMemoryDataUtil memoryDataUtil;

    @Override
    @RabbitListener(queues = {ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT_SUCCESS, ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT_FAIL})
    public void consume(String message) {
        log.info("Received message: " + message);

        DocumentResponse documentRequest = JsonUtil.convertFromJson(message, DocumentResponse.class);

        memoryDataUtil.setValue(documentRequest.getDocument(), documentRequest.getStatus());
    }
}