package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerCreateResponse;
import br.com.acmepay.application.domain.model.CustomerDomain;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customers")
public interface ICustomerResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CustomerCreateResponse create(@RequestBody CustomerRequest request);
//
//
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    List<CustomerDomain> list();
}
