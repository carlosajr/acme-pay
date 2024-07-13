package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.request.TransactionRequest;

public interface ICreateTransaction {
    void execute(TransactionRequest transactionRequest);
}
