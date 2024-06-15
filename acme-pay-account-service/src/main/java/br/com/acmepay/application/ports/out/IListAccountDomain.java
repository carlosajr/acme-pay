package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.models.AccountDomain;

import java.util.List;

public interface IListAccountDomain {
    List<AccountDomain> execute();
}
