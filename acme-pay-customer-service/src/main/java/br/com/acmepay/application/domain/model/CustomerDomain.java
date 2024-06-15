package br.com.acmepay.application.domain.model;

import br.com.acmepay.application.ports.out.ICreateCustomer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private Boolean close;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateCustomer createAccount) {
        createAccount.execute(this);
    }
}