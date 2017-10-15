package com.qazaq.android.mobile3;

/**
 * Created by User on 12.10.2017.
 */

public class Info {
    private String objectId;
    private String title;
    private String content;
    private String image;

    public Info() {
    }

    public Info(String content, String image, String title) {
        this.content = content;
        this.image = image;
        this.title = title;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
