package com.vf.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int category_id;
    private String category_name;

    public Product(String name, String description, double price, int category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(int id, String name, String description, double price, int category_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
    }
    public void delete(){}
}



