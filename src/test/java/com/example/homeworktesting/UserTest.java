package com.example.homeworktesting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.example.homeworktesting.constants.GreetingsServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static final User user = new User("skypro.777", "skypro.777@mail.ru");

    @AfterAll
    static void afterAll() {
        System.out.println("Testing is finish");
    }

    @Test
    public void shouldAddUserWithTwoParameters() {
        assertFalse(user.getLogin().isEmpty() && user.getLogin().isBlank());
        assertFalse(user.getEmail().isEmpty() && user.getEmail().isBlank());
    }

    @Test
    public void shouldAddUserWithoutParameters() {
        assertFalse(new User().canEqual(null));
    }

    @Test
    public void shouldCheckLoginForUser() {
        Assertions.assertTrue(user.getEmail().contains(".") && user.getEmail().contains("@"));
    }

    @Test
    public void shouldCheckEqualityOfLoginAndEmail() {
        assertNotEquals(user.getLogin(), user.getEmail());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenEmailContainsIllegalCharacters() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> user.generateGreetings(ILLEGAL_CHARACTERS_EMAIL)
        );
    }
}