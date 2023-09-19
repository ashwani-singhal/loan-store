package com.loanstore.loanstore.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public
class LoanAggregate {
    private double remainingAmount;
    private double interest;
    private double penalty;

    // Constructors, getters, and setters
}