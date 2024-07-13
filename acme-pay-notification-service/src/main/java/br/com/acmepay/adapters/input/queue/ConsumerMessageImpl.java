package br.com.acmepay.adapters.input.queue;

import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.domain.model.DocumentDomain;
import br.com.acmepay.application.ports.IValidateDocumentUseCase;
import br.com.acmepay.constants.ConstantsRabbitMQ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsumerMessageImpl implements ConsumerMessage {

    private final IValidateDocumentUseCase validateDocumentUseCase;

    @Override
    @RabbitListener(queues = ConstantsRabbitMQ.QUEUE_CHECK_DOCUMENT)
    public void consume(DocumentRequest documentRequest) {
        log.info("Received document: {}", documentRequest);

        var document = documentRequest.getDocument();
        var domain = DocumentDomain.builder().document(document).build();

        validateDocumentUseCase.execute(domain);
    }
}
