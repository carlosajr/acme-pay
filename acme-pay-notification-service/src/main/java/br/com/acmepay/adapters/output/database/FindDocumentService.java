package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.entity.DocumentEntity;
import br.com.acmepay.adapters.output.database.repository.DocumentRepository;
import br.com.acmepay.application.domain.model.DocumentDomain;
import br.com.acmepay.application.enums.DocumentStatus;
import br.com.acmepay.application.ports.out.IFindDocumentDomain;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FindDocumentService implements IFindDocumentDomain {

    private DocumentRepository repository;

    @Override
    public DocumentDomain execute(String document) {
        Specification<DocumentEntity> documentSpec = (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("document"), document);

        Optional<DocumentEntity> optionalEntity = repository.findOne(documentSpec);

        return optionalEntity.map(this::toDomain)
                .orElseThrow(() -> new RuntimeException("No document found for the specified criteria"));
    }

    private DocumentDomain toDomain(DocumentEntity entity) {
        return DocumentDomain.builder()
                .id(entity.getId())
                .document(entity.getDocument())
                .status(DocumentStatus.valueOf(entity.getStatus().toUpperCase()))
                .build();
    }
}
