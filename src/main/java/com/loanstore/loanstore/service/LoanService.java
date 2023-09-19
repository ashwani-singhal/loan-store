package com.loanstore.loanstore.service;

import com.loanstore.loanstore.entity.Loan;
import com.loanstore.loanstore.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository repository;

    public LoanService(LoanRepository loanRepository) {
        repository = loanRepository;
    }


    public Loan saveLoan(Loan loan)
    {
        return repository.save(loan);
    }

    public List<Loan> getAllLoans(){
        return repository.findAll();
    }

    public Loan getLoanByLoanId(String loanId){
        return repository.findById(loanId).orElse(null);
    }

    public Loan getLoanByCustomerId(String customerId){
        return repository.findById(customerId).orElse(null);
    }

    public Loan getLoanByLenderId(String lenderId){
        return repository.findById(lenderId).orElse(null);
    }
}
