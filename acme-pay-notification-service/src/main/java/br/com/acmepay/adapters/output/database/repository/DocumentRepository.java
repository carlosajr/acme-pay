package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long>, JpaSpecificationExecutor<DocumentEntity> {
}
