package com.loanstore.loanstore.controller;

import com.loanstore.loanstore.entity.Loan;
import com.loanstore.loanstore.entity.LoanAggregate;
import com.loanstore.loanstore.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;


public class LoanController {

    private LoanService service;

    private final List<Loan> loanStore = new ArrayList<>();

    @PostMapping("/loans/add")
    public Loan addLoan(@RequestBody Loan loan){
        return service.saveLoan(loan);
    }

    @GetMapping("/loans")
    public List<Loan> getLoans(){
        return service.getAllLoans();
    }

    @GetMapping("/loans/{loanId}")
    public Loan getLoanByLoanId(@PathVariable String loanId){
        return service.getLoanByLoanId(loanId);
    }

    @GetMapping("/loans/{customerId}")
    public Loan getLoanByCustomerId(@PathVariable String customerId){
        return service.getLoanByCustomerId(customerId);
    }

    @GetMapping("/loans/{lenderId}")
    public Loan getLoanByLenderId(@PathVariable String lenderId){
        return service.getLoanByLenderId(lenderId);
    }

    @GetMapping("/aggregate/lender")
    public ResponseEntity<LoanAggregate> getAggregateLoansByLender() {
        // Implement aggregation logic here
        return ResponseEntity.ok(new LoanAggregate());
    }

    @GetMapping("/aggregate/customer")
    public ResponseEntity<LoanAggregate> getAggregateLoansByCustomer() {
        // Implement aggregation logic here
        return ResponseEntity.ok(new LoanAggregate());
    }

    @GetMapping("/aggregate/interest")
    public ResponseEntity<LoanAggregate> getAggregateLoansByInterest() {
        // Implement aggregation logic here
        return ResponseEntity.ok(new LoanAggregate());
    }

    private void validateLoan(Loan loan) {
        // Implement validation logic here
        if (loan.getPaymentDate().isAfter(loan.getDueDate())) {
            throw new IllegalArgumentException("Payment date cannot be greater than the due date.");
        }
    }

    private Loan findLoanById(String loanId) {
        return loanStore.stream()
                .filter(loan -> loan.getLoanId().equals(loanId))
                .findFirst()
                .orElse(null);
    }
}
}
