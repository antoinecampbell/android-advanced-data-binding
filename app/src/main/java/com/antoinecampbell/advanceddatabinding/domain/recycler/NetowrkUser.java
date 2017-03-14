package com.antoinecampbell.advanceddatabinding.domain.recycler;

/**
 * @author acampbell
 */
public class NetowrkUser {

    private final String name;
    private final String imageUrl;

    public NetowrkUser(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
