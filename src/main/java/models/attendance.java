package models;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class attendance {
    private int id;
    private Timestamp date;
    private int userID;
    private int cohortID;
    private Timestamp signInTime;
    private int score;

    public attendance(int id, Timestamp date, int userID, int cohortID, Timestamp signInTime, int score) {
        this.id = id;
        this.date = date;
        this.userID = userID;
        this.cohortID = cohortID;
        this.signInTime = signInTime;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCohortID() {
        return cohortID;
    }

    public void setCohortID(int cohortID) {
        this.cohortID = cohortID;
    }

    public Timestamp getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Timestamp signInTime) {
        this.signInTime = signInTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof attendance)) return false;
        attendance that = (attendance) o;
        return getId() == that.getId() &&
                getUserID() == that.getUserID() &&
                getCohortID() == that.getCohortID() &&
                getScore() == that.getScore() &&
                getDate().equals(that.getDate()) &&
                getSignInTime().equals(that.getSignInTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getUserID(), getCohortID(), getSignInTime(), getScore());
    }
}
