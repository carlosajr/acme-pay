package br.com.acmepay.adapters.output.database.entity;

import br.com.acmepay.application.enums.DocumentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "documents")
public class DocumentEntity {
    @Id
    @SequenceGenerator(name = "account_seq",
    sequenceName = "account_seq",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "account_seq")
    private Long id;

    private String document;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
