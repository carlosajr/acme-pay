package br.com.acmepay.application.ports;

import br.com.acmepay.application.domain.model.DocumentDomain;

public interface IValidateDocumentUseCase {
    void execute(DocumentDomain domain);
}
