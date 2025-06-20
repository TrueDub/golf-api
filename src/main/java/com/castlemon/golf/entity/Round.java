package com.castlemon.golf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Round {

    private @Id
    @GeneratedValue int id;
    private LocalDate date;
    private String courseName;
    private String tees;
    private int slope;
    private double courseRating;
    private String score;
    private int pcc;
    private double diff;
    private int holesPlayed;
    private double handicap;

    public Round(LocalDate date, String courseName, String tees, int slope, double courseRating,
                 String score, int pcc, double diff, int holesPlayed, double handicap) {
        this.date = date;
        this.courseName = courseName;
        this.tees = tees;
        this.slope = slope;
        this.courseRating = courseRating;
        this.score = score;
        this.pcc = pcc;
        this.diff = diff;
        this.holesPlayed = holesPlayed;
        this.handicap = handicap;
    }

    public Round() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getPcc() {
        return pcc;
    }

    public void setPcc(int pcc) {
        this.pcc = pcc;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public int getHolesPlayed() {
        return holesPlayed;
    }

    public void setHolesPlayed(int holesPlayed) {
        this.holesPlayed = holesPlayed;
    }

    public double getHandicap() {
        return handicap;
    }

    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Round round1)) return false;
        return id == round1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Round{" + "id=" + this.id + ", name='" + this.courseName + '\'' + ", date='" + this.date + '\'' + '}';
    }
}
