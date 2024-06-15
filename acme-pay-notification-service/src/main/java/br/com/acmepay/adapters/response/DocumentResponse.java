package br.com.acmepay.adapters.response;

import br.com.acmepay.application.enums.DocumentStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DocumentResponse implements Serializable {
    private String document;
    private DocumentStatus status;
}