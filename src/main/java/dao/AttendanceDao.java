package dao;

import models.Attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;

public interface AttendanceDao {
    public List<Attendance>getAllAttendance()throws Exception;

    public List<Attendance>getAllAttendanceById()throws Exception;

    public List<Attendance> getAttendance(String id,int mon)throws Exception;

}
