package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {
    private final String expectedName = "Moringa Student";
    private final String expectedEmail = "ms-student@gmail.com";
    Date date = new Date();
    private final Timestamp expectedRegistrationDate = new Timestamp(date.getTime());
    private final String expectedPassword = "killmonger";
    private final String expectedCohortId = "MC-22";
    private final String expectedModule = "Java";
    private final int expectedRole = 1;

    @Test
    public void newUserInstantiatescorrectly_true() {
        User testUser = createUser();
        assertTrue(testUser instanceof User);
    }

    @Test
    public void getName_returnsCorrectName() {
        User testUser = createUser();
        assertEquals(expectedName, testUser.getName());
    }

    @Test
    public void getEmail_returnsCorrectEmail() {
        User testUser = createUser();
        assertEquals(expectedEmail, testUser.getName());
    }

    @Test
    public void getRegistrationDate_returnsCorrectDate() {
        User testUser = createUser();
        assertEquals(expectedRegistrationDate, testUser.getRegisterDate());
    }

    @Test
    public void getEPassword_returnsCorrectPassword() {
        User testUser = createUser();
        assertEquals(expectedPassword, testUser.getPassword());
    }

    @Test
    public void getCohordId_returnsCorrectCohort() {
        User testUser = createUser();
        assertEquals(expectedCohortId, testUser.getCohortId());
    }

    @Test
    public void getRole_returnsCorrectRole() {
        User testUser = createUser();
        assertEquals(expectedRole, testUser.getRole());
    }

    private User createUser() {
        return new User(expectedName, expectedEmail, expectedRegistrationDate, expectedPassword, expectedCohortId, expectedModule, expectedRole);
    }


}