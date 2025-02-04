package com.example.CasaOrganizada.Registration;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {
        return email != null && email.contains("@");
    }
}
