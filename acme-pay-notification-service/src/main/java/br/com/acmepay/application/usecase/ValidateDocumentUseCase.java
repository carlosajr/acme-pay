package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.DocumentDomain;
import br.com.acmepay.application.ports.IValidateDocumentUseCase;
import br.com.acmepay.application.ports.out.IFindDocumentDomain;
import br.com.acmepay.application.ports.out.IRespondDocumentCustomerCheck;
import br.com.acmepay.application.ports.out.IValidateDocument;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class ValidateDocumentUseCase implements IValidateDocumentUseCase {
    private final IFindDocumentDomain findDocumentDomain;
    private final IRespondDocumentCustomerCheck respondDocumentCustomerCheck;

    @Override
    public void execute(DocumentDomain domain) {
        domain.validateDocument(findDocumentDomain, respondDocumentCustomerCheck);
    }
}
