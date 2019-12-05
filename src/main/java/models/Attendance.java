package models;
import java.sql.Timestamp;
import java.util.Objects;
import java.time.LocalDateTime;

import java.io.Serializable;


public class Attendance implements Serializable{
    private int id;
    private Timestamp date;
    private int userID;
    private int cohortID;
    private Timestamp signInTime;
    private int score;
    private String attDate;
    private String deviceId;
    private String timein;
    private String lateIn;
    private String timeout;

    public Attendance(int id, Timestamp date, int userID, int cohortID, Timestamp signInTime, int score,
      String attDate,String deviceId,String timein,String lateIn,String timeout
    ) {
        this.id = id;
        this.date = date;
        this.userID = userID;
        this.cohortID = cohortID;
        this.signInTime = signInTime;
        this.score = score;
        this.attDate =attDate;
        this.deviceId =deviceId;
        this.timein =timein;
        this.lateIn=lateIn;
        this.timeout=timeout;

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

    public String getAttDate() {
        return attDate;
    }

    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimein() {
        return timein;
    }

    public void setTimein(String timein) {
        this.timein = timein;
    }

    public String getLateIn() {
        return lateIn;
    }

    public void setLateIn(String lateIn) {
        this.lateIn = lateIn;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendance)) return false;
        Attendance that = (Attendance) o;
        return getId() == that.getId() &&
                getUserID() == that.getUserID() &&
                getCohortID() == that.getCohortID() &&
                getScore() == that.getScore() &&
                getDate().equals(that.getDate()) &&
                getSignInTime().equals(that.getSignInTime())&&
                getAttDate().equals(that.getAttDate())&&
                getDeviceId().equals(that.getDeviceId())&&
                getTimein().equals(that.getTimein())&&
                getTimeout().equals(that.getTimeout())&&
                getLateIn().equals(that.getLateIn());


    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDate(), getUserID(), getCohortID(), getSignInTime(), getScore(),getAttDate(),getDeviceId(),
        getLateIn(),getTimein(),getTimeout());
    }
}
