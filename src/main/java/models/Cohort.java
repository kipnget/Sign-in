package models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Objects;

public class Cohort {
    private int cohort_id;
    private String name;
    private String module;
    private Timestamp startDate;
    private Timestamp endDate;

    public Cohort( String name, String module, Timestamp startDate, Timestamp endDate) {
        this.cohort_id = cohort_id;
        this.name = name;
        this.module = module;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(int id) {
        this.cohort_id = cohort_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
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
        if (!(o instanceof Cohort)) return false;
        Cohort cohort = (Cohort) o;
        return getName().equals(cohort.getName()) &&
                getModule().equals(cohort.getModule()) &&
                getStartDate().equals(cohort.getStartDate()) &&
                getEndDate().equals(cohort.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getModule(), getStartDate(), getEndDate());
    }
}
