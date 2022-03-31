package com.yfh.dczx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
public class Student {
    private Integer id;
    private Integer examNo;
    private String stuName;
    private Double chinese;
    private Double math;
    private Double english;
    private Double politics;
    private Double history;
    private Double geography;
    private Double biology;

    private Double totalScore;

    public Student(Integer id, Integer examNo, String stuName, Double chinese, Double math, Double english, Double politics, Double history, Double geography, Double biology) {
        this.id = id;
        this.examNo = examNo;
        this.stuName = stuName;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.politics = politics;
        this.history = history;
        this.geography = geography;
        this.biology = biology;
    }

    public Double getTotalScore() {
        BigDecimal bigChinese = new BigDecimal(getChinese() + "");
        BigDecimal bigMath = new BigDecimal(getMath() + "");
        BigDecimal bigEnglish = new BigDecimal(getEnglish() + "");
        BigDecimal bigPolitics = new BigDecimal(getPolitics() + "");
        BigDecimal bigHistory = new BigDecimal(getHistory() + "");
        BigDecimal bigGeography = new BigDecimal(getGeography() + "");
        BigDecimal bigBiology = new BigDecimal(getBiology() + "");
        BigDecimal bigTotal = bigChinese.add(bigMath).add(bigEnglish).add(bigPolitics).add(bigHistory)
                .add(bigGeography).add(bigBiology);
        return bigTotal.doubleValue();
    }
}
