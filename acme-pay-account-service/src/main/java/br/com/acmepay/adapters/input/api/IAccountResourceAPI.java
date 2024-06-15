package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.application.domain.exception.AccountSuspendedException;
import br.com.acmepay.application.domain.models.AccountDomain;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/accounts")
public interface IAccountResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccountResponse create(@RequestBody AccountRequest request) throws InterruptedException, AccountSuspendedException;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<AccountDomain> list(@RequestBody AccountRequest request);
}
