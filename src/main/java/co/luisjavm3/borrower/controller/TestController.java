package co.luisjavm3.borrower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String test() {
        return "Borrower Service - OK - v1";
    }

    @GetMapping("/loop")
    public String test1() {
        for (int i = 0; i < 100; i++) {

        }

        return "Loan Service : Loop OK";
    }
}
