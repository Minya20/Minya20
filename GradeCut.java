package com.example.project_01;

public class GradeCut {
    public String grade;
    public String r_score;
    public String st_score;
    public String percentile;

    public void setGrade(String Grade) {
        this.grade = Grade;
    }

    public void setRScore(String RScore) {
        this.r_score = RScore;
    }

    public void setStScore(String StScore) {
        this.st_score = StScore;
    }

    public void setPercentile(String Percentile) {
        this.percentile = Percentile;
    }

    public String getGrade() {
        return grade;
    }

    public String getRScore(int RScore) { return r_score; }

    public String getStScore(int StScore) {
        return st_score;
    }

    public String getPercentile(int Percentile) {
        return percentile;
    }

}

