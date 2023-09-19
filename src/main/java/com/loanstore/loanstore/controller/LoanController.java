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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
        Map<String, LoanAggregate> aggregates = new HashMap<>();

        for (Loan loan : loanStore) {
            String lenderId = loan.getLenderId();
            LoanAggregate aggregate = aggregates.getOrDefault(lenderId, new LoanAggregate());

            aggregate.setRemainingAmount(aggregate.getRemainingAmount() + loan.getRemainingAmount());
            aggregate.setInterest(aggregate.getInterest() + calculateInterest(loan));
            aggregate.setPenalty(aggregate.getPenalty() + calculatePenalty(loan));

            aggregates.put(lenderId, aggregate);
        }

        return ResponseEntity.ok(aggregates.values().stream().collect(Collectors.toList()));
    }

    @GetMapping("/aggregate/customer")
    public ResponseEntity<LoanAggregate> getAggregateLoansByCustomer() {
        Map<String, LoanAggregate> aggregates = new HashMap<>();

        for (Loan loan : loanStore) {
            String customerId = loan.getCustomerId();
            LoanAggregate aggregate = aggregates.getOrDefault(customerId, new LoanAggregate());

            aggregate.setRemainingAmount(aggregate.getRemainingAmount() + loan.getRemainingAmount());
            aggregate.setInterest(aggregate.getInterest() + calculateInterest(loan));
            aggregate.setPenalty(aggregate.getPenalty() + calculatePenalty(loan));

            aggregates.put(customerId, aggregate);
        }

        return ResponseEntity.ok(aggregates.values().stream().collect(Collectors.toList()));
    }

    @GetMapping("/aggregate/interest")
    public ResponseEntity<LoanAggregate> getAggregateLoansByInterest() {
        Map<Double, LoanAggregate> aggregates = new HashMap<>();

        for (Loan loan : loanStore) {
            double interestRate = loan.getInterestPerDay();
            LoanAggregate aggregate = aggregates.getOrDefault(interestRate, new LoanAggregate());

            aggregate.setRemainingAmount(aggregate.getRemainingAmount() + loan.getRemainingAmount());
            aggregate.setInterest(aggregate.getInterest() + calculateInterest(loan));
            aggregate.setPenalty(aggregate.getPenalty() + calculatePenalty(loan));

            aggregates.put(interestRate, aggregate);
        }

        return ResponseEntity.ok(aggregates.values().stream().collect(Collectors.toList()));
    }

    private double calculateInterest(Loan loan) {

        return 0.0;
    }

    private double calculatePenalty(Loan loan) {

        return 0.0;
    }

}
}
