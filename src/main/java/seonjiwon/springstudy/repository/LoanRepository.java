package seonjiwon.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seonjiwon.springstudy.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
