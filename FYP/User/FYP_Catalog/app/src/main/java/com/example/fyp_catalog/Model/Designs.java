package com.example.fyp_catalog.Model;

public class Designs {
    private String code, name, imgUrl, description, category, id, metal;

    public Designs()
    {

    }

    public Designs(String code, String name, String imgUrl, String description, String category, String id, String metal) {
        this.code = code;
        this.name = name;
        this.imgUrl = imgUrl;
        this.description = description;
        this.category = category;
        this.id = id;
        this.metal = metal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }
}





