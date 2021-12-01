package com.example.fitnessapplication402;

public class WaterCount {
    private int wCount;

    public WaterCount(){
        wCount = 0;
    }
    public void addCount(){
        wCount++;
    }
    public Integer getCount(){
        return wCount;
    }
}