package com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler;

import android.graphics.Bitmap;

/**
 * Created by Jyotirmay on 06-Feb-18.
 */

public class DataBean {

    private String name;
    private String skills;
    private String imagePath;

    public String getImage() {
        return imagePath;
    }

    public void setImage(String image) {
        this.imagePath = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
