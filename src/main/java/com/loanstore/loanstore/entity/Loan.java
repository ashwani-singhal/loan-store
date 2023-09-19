package com.loanstore.loanstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOAN_TABLE")
public class Loan {

    @Id
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
