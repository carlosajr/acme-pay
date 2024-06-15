package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.model.CustomerDomain;

public interface ICreateCustomer {
    void execute(CustomerDomain customerDomain);
}
