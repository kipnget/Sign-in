package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class CohortTest {
    Date date = new Date();
    private final String expectedName = "MC-22";
    private final String expectedModule = "Java";
    private final Timestamp expectedStartDate = new Timestamp(date.getTime());
    private final Timestamp expectedEndDate = new Timestamp(date.getTime());

    @Test
    public void newUserInstantiatescorrectly_true() {
        Cohort testCohort = createCohort();
        assertTrue(testCohort instanceof Cohort);
    }

    @Test
    public void getName_returnsCorrectName() {
        Cohort testCohort = createCohort();
        assertEquals(expectedName, testCohort.getName());
    }

    @Test
    public void getModule_returnsCorrectModule() {
        Cohort testCohort = createCohort();
        assertEquals(expectedModule, testCohort.getModule());
    }

    @Test
    public void getStartDate_returnsCorrectDate() {
        Cohort testCohort = createCohort();
        assertEquals(expectedStartDate, testCohort.getStartDate());
    }

    @Test
    public void getEndDate_returnsCorrectDate() {
        Cohort testCohort = createCohort();
        assertEquals(expectedEndDate, testCohort.getEndDate());
    }

    private Cohort createCohort() {
        Cohort testCohort = new Cohort(expectedName, expectedModule, expectedStartDate, expectedEndDate);
        return testCohort;
    }

}