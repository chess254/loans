package com.pezesha.loans.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferDto {

    @jakarta.validation.constraints.NotNull(message = "Sender Account Id should not be null")
    @Min(1)
    private Long sourceAccountId;
    @jakarta.validation.constraints.NotNull(message = "Sender Account Id should not be null")
    @Min(1)
    private Long destinationAccountId;
    @jakarta.validation.constraints.NotNull(message = "deposit value should be provided")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=10, fraction=2, message = "allowed format is Maximum 10 digits with 2 decimal places")
    private BigDecimal amount;
}
