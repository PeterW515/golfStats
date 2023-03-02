package com.pwgolf.golfStats.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class PlayerAveragesDTO implements Serializable {
    private double averageFIR;
    private double averageGIR;
    private double averageUpDown;
    private double averagePutts;
    private double averageScore;
    private double averagePar3Score;
    private double averagePar4Score;
    private double averagePar5Score;

    public double getAverageFIR() {
        return averageFIR;
    }

    public void setAverageFIR(double averageFIR) {
        this.averageFIR = averageFIR;
    }

    public double getAverageGIR() {
        return averageGIR;
    }

    public void setAverageGIR(double averageGIR) {
        this.averageGIR = averageGIR;
    }

    public double getAverageUpDown() {
        return averageUpDown;
    }

    public void setAverageUpDown(double averageUpDown) {
        this.averageUpDown = averageUpDown;
    }

    public double getAveragePutts() {
        return averagePutts;
    }

    public void setAveragePutts(double averagePutts) {
        this.averagePutts = averagePutts;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public double getAveragePar3Score() {
        return averagePar3Score;
    }

    public void setAveragePar3Score(double averagePar3Score) {
        this.averagePar3Score = averagePar3Score;
    }

    public double getAveragePar4Score() {
        return averagePar4Score;
    }

    public void setAveragePar4Score(double averagePar4Score) {
        this.averagePar4Score = averagePar4Score;
    }

    public double getAveragePar5Score() {
        return averagePar5Score;
    }

    public void setAveragePar5Score(double averagePar5Score) {
        this.averagePar5Score = averagePar5Score;
    }

    @Override
    public String toString() {
        return "PlayerAveragesDTO{" +
                "averageFIR=" + averageFIR +
                ", averageGIR=" + averageGIR +
                ", averageUpDown=" + averageUpDown +
                ", averagePutts=" + averagePutts +
                ", averageScore=" + averageScore +
                ", averagePar3Score=" + averagePar3Score +
                ", averagePar4Score=" + averagePar4Score +
                ", averagePar5Score=" + averagePar5Score +
                '}';
    }
}
