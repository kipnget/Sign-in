package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class CohortsTest {
    Date date = new Date();
    private final String expectedName = "MC-22";
    private final String expectedModule = "Java";
    private final Timestamp expectedStartDate = new Timestamp(date.getTime());
    private final Timestamp expectedEndDate = new Timestamp(date.getTime());

    @Test
    public void newUserInstantiatescorrectly_true() {
        Cohorts testCohort = createCohort();
        assertTrue(testCohort instanceof Cohorts);
    }

    @Test
    public void getName_returnsCorrectName() {
        Cohorts testCohort = createCohort();
        assertEquals(expectedName, testCohort.getName());
    }

    @Test
    public void getModule_returnsCorrectModule() {
        Cohorts testCohort = createCohort();
        assertEquals(expectedModule, testCohort.getModule());
    }

    @Test
    public void getStartDate_returnsCorrectDate() {
        Cohorts testCohort = createCohort();
        assertEquals(expectedStartDate, testCohort.getStartDate());
    }

    @Test
    public void getEndDate_returnsCorrectDate() {
        Cohorts testCohort = createCohort();
        assertEquals(expectedEndDate, testCohort.getEndDate());
    }

    private Cohorts createCohort() {
        Cohorts testCohort = new Cohorts(expectedName, expectedModule, expectedStartDate, expectedEndDate);
        return testCohort;
    }

}