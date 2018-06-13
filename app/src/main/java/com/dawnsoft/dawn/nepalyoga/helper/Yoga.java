package com.dawnsoft.dawn.nepalyoga.helper;

/**
 * Created by dawn on 3/27/2018.
 */

public class Yoga {

    private int image;
    private String title;
    private int noOfClass;
    private String difficulty;
    private int time;

    //empty constructor
    public Yoga(){}

    //constructor having arguments
    public Yoga(int image, String title, int noOfClass, String difficulty, int time) {
        this.image = image;
        this.title = title;
        this.noOfClass = noOfClass;
        this.difficulty = difficulty;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getNoOfClass() {
        return noOfClass;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getTime() {
        return time;
    }

}
