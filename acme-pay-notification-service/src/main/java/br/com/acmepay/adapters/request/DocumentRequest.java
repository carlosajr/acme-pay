package br.com.acmepay.adapters.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
public class DocumentRequest implements Serializable {
    private String document;

    @JsonCreator
    public DocumentRequest(@JsonProperty("document") String document) {
        this.document = document;
    }
}
