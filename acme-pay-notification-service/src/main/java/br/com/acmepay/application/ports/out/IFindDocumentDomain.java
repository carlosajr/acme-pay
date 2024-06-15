package br.com.acmepay.application.ports.out;


import br.com.acmepay.application.domain.model.DocumentDomain;

import java.util.List;

public interface IFindDocumentDomain {
    DocumentDomain execute(String document);
}
