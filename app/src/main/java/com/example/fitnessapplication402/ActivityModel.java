package com.example.fitnessapplication402;

public class ActivityModel {

    // string course_name for storing activity_name
    // and imgid for storing image id.
    private String activity_name;
    private int imgid;

    public ActivityModel(String activity_name, int imgid) {
        this.activity_name = activity_name;
        this.imgid = imgid;
    }

    public String getCourse_name() {
        return activity_name;
    }

    public void setCourse_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
