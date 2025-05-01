package co.luisjavm3.borrower.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.luisjavm3.borrower.Model.DTO.Loan.LoanDto;

@FeignClient(name = "loan-service", url = "${creso.demo.loan-service.url}")
public interface LoanClient {
    @GetMapping("/borrower/{borrowerId}")
    List<LoanDto> findByBorrowerId(@PathVariable("borrowerId") long borrowerId);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") long id);
}
