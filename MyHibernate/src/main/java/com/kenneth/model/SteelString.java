package com.kenneth.model;

import jakarta.persistence.*;

import java.lang.annotation.Repeatable;

@Entity
@Table(name = "steel_string")
// when creating table from within this class instead of defining in another class
@SecondaryTable(name = "guitarist",pkJoinColumns = @PrimaryKeyJoinColumn(
        name="guitar",referencedColumnName = "id"
))
public class SteelString {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",columnDefinition = "smallint auto_increment")
    private short id;
    @Column(table="guitarist",name="name")
    private String owner;

/*    // basic column
    @Column(name = "material", columnDefinition = "varchar(16) not null")
    private String material;*/
    // embedded class as column(s)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name",column = @Column(name="materialname")),
            @AttributeOverride(name = "color",column = @Column(name="materialcolor"))
    })
    private Material material;

    @ElementCollection
    @CollectionTable(name="materials",joinColumns =
    @JoinColumn(name="guitar_id",referencedColumnName = "id"))
    private Material[] materials;

/*  //creates a new table with spec. column, don't need separate class def for table
    @Column(name = "name",table = "brand")
    private String brand;*/

    //define a class for the table with the foreign key
    @ManyToOne
//    @JoinColumns(
//            @JoinColumn(name="brand",referencedColumnName = "name")
//    )
    @JoinColumn(
            name = "brand", referencedColumnName = "name"
    )
    private Brand brand;
    public SteelString(){
    }
/*    public SteelString(String mat, Brand bran){
        material = mat;
        brand = bran;
    }
    public String getMaterial() {
        return material;
    }*/
    public SteelString(Material mat, Brand bran){
        material = mat;
        brand = bran;
    }

    public short getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){ this.owner = owner;}
    public void setMaterials(Material[] mats){
        this.materials = mats;
    }
}
