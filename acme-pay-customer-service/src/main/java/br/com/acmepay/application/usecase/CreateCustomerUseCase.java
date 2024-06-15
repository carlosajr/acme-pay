package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCustomerUseCase;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateCustomerUseCase implements ICreateCustomerUseCase {

    private ICreateCustomer createCustomer;

    @Override
    public void execute(CustomerDomain domain) {
        domain.create(createCustomer);
    }
}
