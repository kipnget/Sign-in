package models;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Objects;

public class Users {
    private int id;
    private String name;
    private String email;
    private Timestamp registerDate;
    private String password;
    private int cohortId;
    ArrayList<Integer>module;
    private String role;


    public Users(int id, String name, String email, Timestamp registerDate, String password, int cohortId, ArrayList<Integer> module, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
        this.password = password;
        this.cohortId = cohortId;
        this.module = module;
        this.role=role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public ArrayList<Integer> getModule() {
        return module;
    }

    public void setModule(ArrayList<Integer> module) {
        this.module = module;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId() &&
                getCohortId() == users.getCohortId() &&
                getName().equals(users.getName()) &&
                getEmail().equals(users.getEmail()) &&
                getRegisterDate().equals(users.getRegisterDate()) &&
                getPassword().equals(users.getPassword()) &&
                getModule().equals(users.getModule()) &&
                getRole().equals(users.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getRegisterDate(), getPassword(), getCohortId(), getModule(),getRole());
    }
}
