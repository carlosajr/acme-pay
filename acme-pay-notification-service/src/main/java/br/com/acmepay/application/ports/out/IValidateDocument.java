package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.model.DocumentDomain;

public interface IValidateDocument {
    void execute(DocumentDomain documentDomain);
}

