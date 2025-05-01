package co.luisjavm3.borrower.service.Impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerDto;
import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerInsertDto;
import co.luisjavm3.borrower.Model.Entity.Borrower;
import co.luisjavm3.borrower.repository.BorrowerRepository;
import co.luisjavm3.borrower.service.BorrowerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
    private final LoanRemoverService loanRemoverService;
    private final BorrowerRepository repository;
    private final ModelMapper mapper;

    @Override
    public BorrowerDto addBorrower(BorrowerInsertDto request) {
        Borrower newBorrower = mapper.map(request, Borrower.class);
        repository.addBorrower(newBorrower);
        return mapper.map(newBorrower, BorrowerDto.class);
    }

    @Override
    public Optional<BorrowerDto> findById(long id) {
        return repository.findById(id)
                .map(b -> mapper.map(b, BorrowerDto.class));
    }

    @Override
    public void deleteBorrower(long id) {
        repository.deleteBorrower(id);
        loanRemoverService.removeLoansByBorrowerId(id);
    }

}
