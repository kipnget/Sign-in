package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class UsersTest {
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
        Users testUser = createUser();
        assertTrue(testUser instanceof Users);
    }

    @Test
    public void getName_returnsCorrectName() {
        Users testUser = createUser();
        assertEquals(expectedName, testUser.getName());
    }

    @Test
    public void getEmail_returnsCorrectEmail() {
        Users testUser = createUser();
        assertEquals(expectedEmail, testUser.getName());
    }

    @Test
    public void getRegistrationDate_returnsCorrectDate() {
        Users testUser = createUser();
        assertEquals(expectedRegistrationDate, testUser.getRegisterDate());
    }

    @Test
    public void getEPassword_returnsCorrectPassword() {
        Users testUser = createUser();
        assertEquals(expectedPassword, testUser.getPassword());
    }

    @Test
    public void getCohordId_returnsCorrectCohort() {
        Users testUser = createUser();
        assertEquals(expectedCohortId, testUser.getCohortId());
    }

    @Test
    public void getRole_returnsCorrectRole() {
        Users testUser = createUser();
        assertEquals(expectedRole, testUser.getRole());
    }

    private Users createUser() {
        return new Users(expectedName, expectedEmail, expectedRegistrationDate, expectedPassword, expectedCohortId, expectedModule, expectedRole);
    }


}