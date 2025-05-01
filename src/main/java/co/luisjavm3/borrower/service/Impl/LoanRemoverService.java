package co.luisjavm3.borrower.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.luisjavm3.borrower.Model.DTO.Loan.LoanDto;
import co.luisjavm3.borrower.client.LoanClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoanRemoverService {
    private final LoanClient loanClient;

    public void removeLoansByBorrowerId(long borroreId) {
        List<LoanDto> loans = loanClient.findByBorrowerId(borroreId);

        if (loans.isEmpty())
            return;

        loans.forEach(loan -> {
            loanClient.delete(loan.getId());
        });
    }
}
