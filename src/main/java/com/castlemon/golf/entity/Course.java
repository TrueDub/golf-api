package com.castlemon.golf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Course {

    private @Id
    @GeneratedValue int id;
    private String courseName;
    private String tees;
    private int slope;
    private double courseRating;

    public Course(LocalDate date, String courseName, String tees, int slope, double courseRating) {
        this.courseName = courseName;
        this.tees = tees;
        this.slope = slope;
        this.courseRating = courseRating;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTees() {
        return tees;
    }

    public void setTees(String tees) {
        this.tees = tees;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Course round1)) return false;
        return id == round1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Round{" + "id=" + this.id + ", name='" + this.courseName + '\'' + ", tees='" + this.tees + '\'' + '}';
    }
}
