package co.luisjavm3.borrower.Model.DTO.Borrower;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BorrowerInsertDto {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
