package com.loanstore.loanstore.service;

import com.loanstore.loanstore.entity.Loan;
import com.loanstore.loanstore.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired
    private LoanRepository repository;


    public Loan saveLoan(Loan loan)
    {
        return repository.save(loan);
    }
}
