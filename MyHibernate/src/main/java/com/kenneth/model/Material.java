package com.kenneth.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Material {
    private String name;
    private int color;

    public Material(){};
    public Material(String name){
        this.name = name;
    }
    public Material(String name, int color){
        this.name = name; this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
