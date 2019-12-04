package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class cohorts {
    private int id;
    private String name;
    ArrayList<Integer> module;
    private Timestamp startDate;
    private Timestamp endDate;

    public cohorts(int id, String name, ArrayList<Integer> module, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.name = name;
        this.module = module;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public ArrayList<Integer> getModule() {
        return module;
    }

    public void setModule(ArrayList<Integer> module) {
        this.module = module;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof cohorts)) return false;
        cohorts cohorts = (cohorts) o;
        return getId() == cohorts.getId() &&
                getName().equals(cohorts.getName()) &&
                getModule().equals(cohorts.getModule()) &&
                getStartDate().equals(cohorts.getStartDate()) &&
                getEndDate().equals(cohorts.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getModule(), getStartDate(), getEndDate());
    }
}
