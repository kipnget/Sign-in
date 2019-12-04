package dao;
import models.Cohorts;
import models.Attendance;
import models.Users;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface CohortsDao {
    //create cohort
    void add (Cohorts cohorts);
    //read
    List<Cohorts> getAll();
    Cohorts findById(int id);
    List<Users>getAllUsersInACohort(int id);
    //update
    void update(int id, String name, ArrayList<Integer> module, Timestamp startDate, Timestamp endDate);
    //delete
    void deleteById(int id);
    void clearAll();
}
