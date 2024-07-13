package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.exception.AccountSuspendedException;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.ports.out.ICreateTransaction;
import br.com.acmepay.application.util.UseCase;
import br.com.acmepay.application.util.memory.IMemoryDataUtil;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICreateAccount createAccount;
    private final ICheckDocumentCustomer checkDocumentCustomer;
    private final ICreateTransaction createTransaction;
    private final IMemoryDataUtil memoryDataUtil ;

    @Override
    public void execute(AccountDomain domain) throws InterruptedException, AccountSuspendedException {
        domain.create(createAccount, checkDocumentCustomer, memoryDataUtil, createTransaction);
    }
}
