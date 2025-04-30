package co.luisjavm3.borrower.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerDto;
import co.luisjavm3.borrower.Model.DTO.Borrower.BorrowerInsertDto;
import co.luisjavm3.borrower.service.BorrowerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody BorrowerInsertDto request) {
        BorrowerDto result = service.addBorrower(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        service.deleteBorrower(id);
        return ResponseEntity.noContent().build();
    }
}
