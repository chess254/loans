package com.pezesha.loans.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotNull(message = "deposit value should be provided")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=10, fraction=2, message = "allowed format is Maximum 10 digits with 2 decimal places")
    private BigDecimal deposit;
}
