package dao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql2oUsersDao extends UserDao {
    private final Sql2o sql2o;
    public Sql2oUsersDao(Sql2o sql2o){
        this.sql2o=sql2o;
    }
    @Override
    public void add(User user){
        String sql = "";

        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List<User> getAll(){
        try (Connection con = sql2o.open()) {
            return (List<User>) con.createQuery("SELECT *FROM Users")
            .executeAndFetch(User.class);
        }
    }
    @Override
    public List<User>findById(int id){
        try (Connection con = sql2o.open()) {
            return (List<User>) con.createQuery("SELECT *FROM Users WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetch(User.class);
        }
    }


    @Override
    public List<Cohort> getAll(int id){
        try (Connection con =sql2o.open()){
            return  con.createQuery("SELECT *FROM users WHERE cohort_id=:cohort_id")
                    .executeAndFetch(Cohort.class);
        }
    }
    @Override
    public List<Cohort>getAllCohortById(int cohort_id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("")
                    //.addParameter("module", module)
                    .executeAndFetch(Cohort.class);
        }
    }
    @Override
    public void clearAll(){
        String sql ="DELETE FROM users";
        try (Connection con= sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
