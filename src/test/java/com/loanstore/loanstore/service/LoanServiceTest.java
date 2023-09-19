package com.loanstore.loanstore.service;

import static org.mockito.Mockito.verify;

import com.loanstore.loanstore.repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

// Main class
class LoanServiceTest {

    @Mock private LoanRepository loanRepository;

    private LoanService loanService;

    @BeforeEach void setUp()
    {
        this.loanService
                = new LoanService(this.loanRepository);
    }

    @Test void getAllLoan()
    {
        loanService.getAllLoans();
        verify(loanRepository).findAll();
    }

    @Test
    String getLoanByLoanId(String loanId)
    {
        loanService.getLoanByLoanId(loanId);
        verify(loanRepository).findById(loanId);
        return loanId;
    }

    @Test
    String getLoanByCustomerId(String customerId)
    {
        loanService.getLoanByCustomerId(customerId);
        verify(loanRepository).findById(customerId);
        return customerId;
    }

    @Test
    String getLoanByLenderId(String lenderId)
    {
        loanService.getLoanByLenderId(lenderId);
        verify(loanRepository).findById(lenderId);
        return lenderId;
    }
}

