package com.example.fitnessapplication402;

public class CalcDistance {
    private int dCalced;

    public CalcDistance(){
        dCalced = 0;
    }
    public void CalcTotalDistance(int steps){
        dCalced = ((29 * steps) / 12) / 5280;
    }
    public Integer getTotalDistance(){
        return dCalced;
    }
}
