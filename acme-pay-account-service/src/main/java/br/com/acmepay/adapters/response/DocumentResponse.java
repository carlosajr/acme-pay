package br.com.acmepay.adapters.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class DocumentResponse implements Serializable {
    private String document;
    private String status;

    @JsonCreator
    public DocumentResponse(@JsonProperty("document") String document, @JsonProperty("status") String status) {
        this.document = document;
        this.status = status;
    }
}