package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.response.DocumentResponse;

public interface IRespondDocumentCustomerCheck {
    void execute(DocumentResponse documentResponse);
}
