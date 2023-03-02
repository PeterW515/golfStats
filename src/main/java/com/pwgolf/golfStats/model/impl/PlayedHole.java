package com.pwgolf.golfStats.model.impl;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "played_hole")
public class PlayedHole implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String courseName;
    private String tees;
    private Date datePlayed;
    @NonNull
    private String holeNumber;
    private int par;
    private boolean fairwayInRegulation;
    private String teeShotDirection;
    private boolean greenInRegulation;
    private boolean upAndDown;
    private int putts;
    private int score;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    public String getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(String holeNumber) {
        this.holeNumber = holeNumber;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public boolean isFairwayInRegulation() {
        return fairwayInRegulation;
    }

    public void setFairwayInRegulation(boolean fairwayInRegulation) {
        this.fairwayInRegulation = fairwayInRegulation;
    }

    public String getTeeShotDirection() {
        return teeShotDirection;
    }

    public void setTeeShotDirection(String teeShotDirection) {
        this.teeShotDirection = teeShotDirection;
    }

    public boolean isGreenInRegulation() {
        return greenInRegulation;
    }

    public void setGreenInRegulation(boolean greenInRegulation) {
        this.greenInRegulation = greenInRegulation;
    }

    public boolean isUpAndDown() {
        return upAndDown;
    }

    public void setUpAndDown(boolean upAndDown) {
        this.upAndDown = upAndDown;
    }

    public int getPutts() {
        return putts;
    }

    public void setPutts(int putts) {
        this.putts = putts;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayedHole that = (PlayedHole) o;
        return Objects.equals(courseName, that.courseName) && Objects.equals(tees, that.tees) && Objects.equals(datePlayed, that.datePlayed) && holeNumber.equals(that.holeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, tees, datePlayed, holeNumber);
    }
}