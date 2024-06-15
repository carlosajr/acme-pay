package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.IListAccountUseCase;
import br.com.acmepay.application.ports.out.IListAccountDomain;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class ListAccountUseCase implements IListAccountUseCase {

    private IListAccountDomain listAccountDomain;

    @Override
    public List<AccountDomain> execute(AccountDomain domain) {
        return  domain.list(listAccountDomain);
    }
}
