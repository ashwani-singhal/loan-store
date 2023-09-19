package com.loanstore.loanstore.controller;

import com.loanstore.loanstore.entity.Loan;
import com.loanstore.loanstore.service.LoanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class LoanController {

    private LoanService service;

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
}
