package co.luisjavm3.borrower.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.luisjavm3.borrower.Model.Entity.Borrower;
import co.luisjavm3.borrower.repository.BorrowerRepository;

@Repository
public class BorrowerRepositoryDemoImpl implements BorrowerRepository {
    private static List<Borrower> borrowers;

    static {
        borrowers = new ArrayList<>();
    }

    @Override
    public Borrower addBorrower(Borrower borrower) {
        long max = borrowers.stream()
                .mapToLong(Borrower::getId)
                .max().orElse(0l);

        borrower.setId(max + 1);
        borrowers.add(borrower);
        return borrower;
    }

    @Override
    public Optional<Borrower> findById(long id) {
        return borrowers.stream()
                .filter(b -> b.getId() == id)
                .findFirst();
    }

    @Override
    public void deleteBorrower(long id) {
        borrowers = borrowers.stream()
                .filter(b -> b.getId() != id)
                .toList();
    }

}
