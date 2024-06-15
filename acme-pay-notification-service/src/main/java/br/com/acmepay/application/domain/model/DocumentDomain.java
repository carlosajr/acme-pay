package br.com.acmepay.application.domain.model;

import br.com.acmepay.adapters.response.DocumentResponse;
import br.com.acmepay.application.enums.DocumentStatus;
import br.com.acmepay.application.ports.out.IFindDocumentDomain;
import br.com.acmepay.application.ports.out.IRespondDocumentCustomerCheck;
import br.com.acmepay.application.ports.out.IValidateDocument;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDomain {

    private Long id;
    private String document;
    private DocumentStatus status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public void validateDocument(IFindDocumentDomain findDocumentDomain, IRespondDocumentCustomerCheck respondDocumentCustomerCheck) {
        var documentDomain = findDocumentDomain.execute(this.document);
        var documentResponse = DocumentResponse.builder().document(documentDomain.getDocument()).status(documentDomain.getStatus()).build();
        respondDocumentCustomerCheck.execute(documentResponse);
    }
}
