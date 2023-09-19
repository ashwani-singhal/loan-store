package com.loanstore.loanstore.repository;

import com.loanstore.loanstore.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,String>
{

}
