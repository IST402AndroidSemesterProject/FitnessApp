package com.example.fitnessapplication402;

public class CalcCalories {
    private double dCalced;

    public CalcCalories(){
        dCalced = 0;
    }
    public void CalcTotalBurned(int steps){
        dCalced = steps * .04;
    }
    public Double getTotalBurned(){
        return dCalced;
    }
}
