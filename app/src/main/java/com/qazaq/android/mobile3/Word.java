package com.qazaq.android.mobile3;

/**
 * Created by User on 14.10.2017.
 */

public class Word {

    private String word;
    private String image;

    public Word(){}

    public Word(String image, String word) {
        this.image = image;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

