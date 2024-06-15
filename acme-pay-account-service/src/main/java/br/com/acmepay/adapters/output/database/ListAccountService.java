package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.entity.AccountEntity;
import br.com.acmepay.adapters.output.database.repository.AccountRepository;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.out.IListAccountDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@AllArgsConstructor
@Service
public class ListAccountService implements IListAccountDomain {

    private AccountRepository repository;


    @Override
    public List<AccountDomain> execute() {
        List<AccountEntity> entities = repository.findAll();
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private AccountDomain toDomain(AccountEntity entity) {
        return AccountDomain
                .builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .agency(entity.getAgency())
                .balance(entity.getBalance())
                .created_at(entity.getCreated_at())
                .updated_at(entity.getUpdated_at())
                .build();
    }
}
