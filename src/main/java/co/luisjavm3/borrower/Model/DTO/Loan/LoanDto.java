package co.luisjavm3.borrower.Model.DTO.Loan;

import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerDto;
import lombok.Data;

@Data
public class LoanDto {
    private Long id;
    private BorrowerDto borrower;
    private double principalAmount;
    private double interestRate;
    private int termInMonths;
}
