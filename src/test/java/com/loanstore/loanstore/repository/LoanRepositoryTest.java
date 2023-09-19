package com.loanstore.loanstore.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// Class
public class LoanRepositoryTest {

    private String loanId;
    private String customerId;
    private String lenderId;
    private int amount;
    private int remainingAmount;
    private String paymentDate;
    private int interestPerDay;
    private String dueDate;
    private String penaltyDay;
    private String cancel;
}

