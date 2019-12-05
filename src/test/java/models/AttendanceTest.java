package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttendanceTest {
    Date date = new Date();
    private final Timestamp expectedDate = new Timestamp(date.getTime());
    private final int expectedUserID = 2;
    private final int expectedCohortID = 2;
    private final Timestamp expectedSignInTime = new Timestamp(date.getTime());
    ;
    private final int expectedScore = 100;

    @Test
    public void newUserInstantiatescorrectly_true() {
        Attendance testAttendance = createAttendance();
        assertTrue(testAttendance instanceof Attendance);
    }

    @Test
    public void getDate_returnsCorrectDate() {
        Attendance testAttendance = createAttendance();
        assertEquals(expectedDate, testAttendance.getDate());
    }

    @Test
    public void getCohortId_returnsCorrectId() {
        Attendance testAttendance = createAttendance();
        assertEquals(expectedCohortID, testAttendance.getCohortID());
    }

    @Test
    public void getUserID_returnsCorrectId() {
        Attendance testAttendance = createAttendance();
        assertEquals(expectedUserID, testAttendance.getCohortID());
    }

    @Test
    public void getScore_returnsCorrectScore() {
        Attendance testAttendance = createAttendance();
        assertEquals(expectedScore, testAttendance.getScore());
    }


    private Attendance createAttendance() {
        return new Attendance(expectedDate, expectedUserID, expectedCohortID, expectedSignInTime, expectedScore);
    }

}