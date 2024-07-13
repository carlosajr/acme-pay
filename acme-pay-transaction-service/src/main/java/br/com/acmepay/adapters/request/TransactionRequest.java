package br.com.acmepay.adapters.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest implements Serializable {
    private Integer originAccount;
    private Integer destinationAccount;
    private BigDecimal amount;
    private LocalDateTime date;
}
