package models;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private static String name;
    private static String password;
    private int id;
    private String email;
    private Timestamp registerDate;
    private int cohortId;
    private String module;
    private String role;


    public User(int id, String name, String email, Timestamp registerDate, String password, int cohortId, String module, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registerDate = registerDate;
        this.password = password;
        this.cohortId = cohortId;
        this.module = module;
        this.role=role;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
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

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
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
        if (!(o instanceof User)) return false;
        User users = (User) o;
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
