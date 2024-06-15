package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.domain.exception.AccountSuspendedException;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.enums.DocumentStatus;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.IListAccountDomain;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.util.memory.IMemoryDataUtil;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private String customerDocument;
    private Boolean close;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void create(ICreateAccount createAccount, ICheckDocumentCustomer checkDocumentCustomer, IMemoryDataUtil memoryDataUtil) throws InterruptedException, AccountSuspendedException {

        var doc = DocumentRequest.builder().document(this.customerDocument).build();
        checkDocumentCustomer.execute(doc);

        Thread.sleep(5000);

        var checkDocumentCustomerResponse = DocumentStatus.valueOf(memoryDataUtil.getValue(this.customerDocument));

        if (checkDocumentCustomerResponse.equals(DocumentStatus.SUSPENDED))
            throw new AccountSuspendedException();

        createAccount.execute(this);
    }

    public List<AccountDomain> list(IListAccountDomain listAccountDomain){
        return listAccountDomain.execute();
    }

    public void deposit(BigDecimal amount){
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0){
            this.balance.subtract(amount);
        }else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }
}
