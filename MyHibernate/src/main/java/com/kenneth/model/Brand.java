package com.kenneth.model;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @Column(name = "name", columnDefinition = "varchar(16)")
    private String name;
    public Brand(String name){
        this.name = name;
    }
    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }
    public Brand(){}
    @Override
    public boolean equals(Object o){
        return ((Brand)o).name.equals(this.name);
    }
}

