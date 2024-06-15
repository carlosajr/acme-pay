package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.IAccountResourceAPI;
import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.application.domain.exception.AccountSuspendedException;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.in.IListAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;
    private final IListAccountUseCase listAccountUseCase;

    @Override
    public AccountResponse create(AccountRequest request) throws InterruptedException {
        try {
            var domain = AccountDomain.builder()
                    .created_at(LocalDateTime.now())
                    .updated_at(null)
                    .close(false)
                    .agency(request.getAgency())
                    .number(request.getNumber())
                    .balance(request.getBalance())
                    .customerDocument(request.getCustomerDocument())
                    .build();

            createAccountUseCase.execute(domain);

            return AccountResponse.builder()
                    .message("account created!")
                    .build();
        }catch (AccountSuspendedException error) {
            return AccountResponse.builder()
                    .message(error.getMessage())
                    .build();
        }

    }

    @Override
    public List<AccountDomain> list(AccountRequest request) {
        var domain = AccountDomain.builder().build();

        return listAccountUseCase.execute(domain);
    }


}
