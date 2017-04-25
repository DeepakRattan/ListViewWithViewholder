package com.example.deepakrattan.listview;

/**
 * Created by deepak.rattan on 3/13/2017.
 */

public class SingleRow {
    private String name,desc;
    private int image;

    public SingleRow(String name, String desc, int image) {
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }
}
