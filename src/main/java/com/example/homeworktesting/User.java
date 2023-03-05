package com.example.homeworktesting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class User {

    @NotEmpty
    private String login;

    @Email
    private String email;


    public String generateGreetings(String email) {
        if (email == null || email.isBlank()) {
            return "Greetings, stranger!";
        }
        if (!StringUtils.isAlpha(email)) {
            throw new IllegalArgumentException("Name contains invalid chars: " + email);
        }
        return "Greetings, " + StringUtils.capitalize(email.toLowerCase()) + "!";
    }
}

