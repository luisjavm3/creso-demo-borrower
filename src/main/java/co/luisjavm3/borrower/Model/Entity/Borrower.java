package co.luisjavm3.borrower.Model.Entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Borrower {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
