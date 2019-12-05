package dao;
import models.Cohort;
import models.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface CohortDao {
    //create cohort
    void add (Cohort cohort);
    //read
    List<Cohort> getAll();
    Cohort findById(int id);
    List<User>getAllUserInACohort(int id);
    //update
    void update(int id, String name, ArrayList<Integer> module, Timestamp startDate, Timestamp endDate);
    //delete
    void deleteById(int id);
    void clearAll();
}
