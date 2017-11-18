package com.qazaq.android.mobile3;

/**
 * Created by User on 15.10.2017.
 */

public class WordName {
    private String name;
    private String image;
    private String description;

    public WordName() {}

    public WordName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
