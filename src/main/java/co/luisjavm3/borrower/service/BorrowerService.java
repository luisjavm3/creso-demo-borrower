package co.luisjavm3.borrower.service;

import java.util.Optional;

import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerDto;
import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerInsertDto;

public interface BorrowerService {
    BorrowerDto addBorrower(BorrowerInsertDto request);

    Optional<BorrowerDto> findById(long id);

    void deleteBorrower(long id);
}
