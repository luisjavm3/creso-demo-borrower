package co.luisjavm3.borrower.repository;

import java.util.Optional;

import co.luisjavm3.borrower.Model.Entity.Borrower;

public interface BorrowerRepository {
    Borrower addBorrower(Borrower borrower);

    Optional<Borrower> findById(long id);

    void deleteBorrower(long id);
}
