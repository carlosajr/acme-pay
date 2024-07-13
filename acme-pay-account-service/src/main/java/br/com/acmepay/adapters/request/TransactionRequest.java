package br.com.acmepay.adapters.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionRequest implements Serializable {
    private Integer originAccount;
    private Integer destinationAccount;
    private BigDecimal amount;
    private LocalDateTime date;
}